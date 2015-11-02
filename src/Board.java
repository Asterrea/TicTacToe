import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Board extends JPanel{
    public JButton label4;
    public JButton label1;
    public JButton label7;
    public JButton label2;
    public JButton label5;
    public JButton label8;
    public JButton label3;
    public JButton label6;
    public JButton label9;
    private JLabel labelPlayerName;
    private JLabel labelDifficulty;
    private JScrollPane scroll;
    JTextArea gameEvents;
    private JButton buttonRestart;
    private JLabel labelWinner;

    String playerName;
    int playerTurn;
    String level;
    String player_move = "";
    String computer_move = "";
    
    public Board() {
        //construct components
    	label1 = new JButton ("");
    	label2 = new JButton ("");
    	label3 = new JButton ("");
        label4 = new JButton ("");
        label5 = new JButton ("");
        label6 = new JButton ("");
        label7 = new JButton ("");
        label8 = new JButton ("");
        label9 = new JButton ("");
        labelPlayerName = new JLabel ("Player Name: ");
        labelDifficulty = new JLabel("Level Difficulty: ");
        gameEvents = new JTextArea(5,1);
        scroll = new JScrollPane(gameEvents);
        buttonRestart = new JButton ("Play Again");
        labelWinner = new JLabel ("Player Wins!");

        //set components properties


        //adjust size and set layout
        setPreferredSize (new Dimension (773, 477));
        setLayout (null);

        //add components
        add (label4);
        add (label1);
        add (label7);
        add (label2);
        add (label5);
        add (label8);
        add (label3);
        add (label6);
        add (label9);
        add (labelPlayerName);
        add (labelDifficulty);
        add (scroll);
        add (buttonRestart);
        add (labelWinner);

        //set component bounds (only needed by Absolute Positioning)
        label4.setBounds (0, 160, 150, 160);
        label1.setBounds (0, 0, 150, 160);
        label7.setBounds (0, 320, 150, 160);
        label2.setBounds (150, 0, 155, 160);
        label5.setBounds (150, 160, 155, 160);
        label8.setBounds (150, 320, 155, 160);
        label3.setBounds (305, 0, 155, 160);
        label6.setBounds (305, 160, 155, 160);
        label9.setBounds (305, 320, 155, 160);
        labelPlayerName.setBounds (475, 20, 300, 25);
        labelDifficulty.setBounds(475 , 50, 300 ,25);
        gameEvents.setBounds(475, 80, 280, 200);
        scroll.setBounds(475,80, 280,200);
        buttonRestart.setBounds (570, 345, 100, 25);
        labelWinner.setBounds (580, 300, 80, 25);
        
        labelWinner.setVisible(false);
        buttonRestart.setVisible(false);
    }
    
    public void showActionListenerBoard(String playerName, String nLevel, int turn){
    	labelPlayerName.setText(labelPlayerName.getText().concat(playerName)); 
    	labelDifficulty.setText(labelDifficulty.getText().concat(nLevel));
    	level = nLevel; //set Level
    	this.playerName = playerName;
    	
    	if(turn == 0){ //Player is X
    		player_move = "X"; computer_move="O";
    		callPlayer(turn);
    	}
    	else if (turn == 1) { //Computer is X
    		player_move = "O"; computer_move="X";
    		callComputer(turn);
    	}
		
    	label1.addActionListener(new BoardListener());
    	label2.addActionListener(new BoardListener());
    	label3.addActionListener(new BoardListener());
    	label4.addActionListener(new BoardListener());
    	label5.addActionListener(new BoardListener());
    	label6.addActionListener(new BoardListener());
    	label7.addActionListener(new BoardListener());
    	label8.addActionListener(new BoardListener());
    	label9.addActionListener(new BoardListener());
    	
    }
    
    private void callComputer(int turn){
    	BoardMove move = new BoardMove(turn, computer_move);
    	
    	playerTurn = turn;
    	
		gameEvents.append( playerTurn + " > Computer's Turn\n");
		
		move.computerPlay(level, this);
		
		move.setTurn(playerTurn);
		playerTurn = move.nextTurn();
    }

    private void callPlayer(int turn){
    	BoardMove move = new BoardMove();
    	
    	playerTurn = turn;
		
		gameEvents.append(playerTurn + " > It's your Turn,"+ playerName + "\n");

		move.setTurn(playerTurn);
		playerTurn = move.nextTurn();

    }
    
    private void buttonMove(JButton button){
    	
    	BoardMove move = new BoardMove();
    	
    	button.setText(player_move);
		button.setEnabled(false);
		
		if(playerTurn == 0){
			callPlayer(playerTurn);
		}
		else if (playerTurn == 1){
			callComputer(playerTurn);
		}

		//check if win
		gameEvents.append("Winner! " + move.isGameOver(this) + "\n");
		
    }

	class BoardListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			if(e.getSource().equals(label1)){
				buttonMove(label1);
			}else if(e.getSource().equals(label2)){
				buttonMove(label2);
			}else if(e.getSource().equals(label3)){
				buttonMove(label3);
			}else if(e.getSource().equals(label4)){
				buttonMove(label4);
			}else if(e.getSource().equals(label5)){
				buttonMove(label5);
			}else if(e.getSource().equals(label6)){
				buttonMove(label6);
			}else if(e.getSource().equals(label7)){
				buttonMove(label7);
			}else if(e.getSource().equals(label8)){
				buttonMove(label8);
			}else if(e.getSource().equals(label9)){
				buttonMove(label9);
			}
		}
	}
}
