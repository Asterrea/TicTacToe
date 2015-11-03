import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class TicTacToe2{
	public static String turn = "X";
    public static String curr = "";
	public static int row, col;
        
    JFrame frame;
    JPanel panel;
    JButton board[][];
        
    public TicTacToe2(){
        frame = new JFrame("Tic Tac Toe");
        panel = new JPanel();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,3));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        board = new JButton[3][3];

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                board[i][j] = new JButton();
                board[i][j].setText("");
                board[i][j].addActionListener(new boardAction());
                panel.add(board[i][j]);
            }
        }
        frame.add(panel);
        frame.setVisible(true);
    }
        
    class boardAction implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e){
	        for(row = 0; row < 3; row++){
	            for(col = 0; col < 3; col++){
	                if (e.getSource() == board[row][col] && turn == "X"){
                    	board[row][col].setText(turn);
	                    board[row][col].setEnabled(false);
	                    Play();
	                }
	            }
	        }
        }
    }
	
	public void Play(){
		if(GameOver()){
            JOptionPane.showMessageDialog(null, "Player " + turn + " won!", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
        }
		else if(!maySlotsPa()){
			JOptionPane.showMessageDialog(null, "Draw", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
		}
		else{
	        if(turn.equals("X"))
	        	turn = "O";
	        else
	            turn = "X";
	        level1(turn);
	        if(GameOver()){
	            JOptionPane.showMessageDialog(null, "Player " + turn + " won!", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
	        }
	        else if(!maySlotsPa()){
	            JOptionPane.showMessageDialog(null, "Draw", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
	        }
		}
		if(turn.equals("X"))
        	turn = "O";
        else
            turn = "X";
    }
	
	public boolean maySlotsPa(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(board[i][j].getText()=="")
					return true;
			}
		}
		return false;
	}
	
	public void level1(String turn){
		Random rand = new Random();
		int r, c, found = 0;
		if(turn == "O"){ //if it is computer's turn
			if(board[0][0].getText()=="X"){
				if(board[1][0].getText()=="X" && board[2][0].getText()==""){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else if(board[1][0].getText()=="" && board[2][0].getText()=="X"){
					board[1][0].setText(turn);
					board[1][0].setEnabled(false);
				}
				else if(board[0][1].getText()=="X" && board[0][2].getText()==""){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else if(board[0][1].getText()=="" && board[0][2].getText()=="X"){
					board[0][1].setText(turn);
					board[0][1].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[2][2].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[1][0].getText()=="X"){
				if(board[0][0].getText()=="X" && board[2][0].getText()==""){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else if(board[0][0].getText()=="" && board[2][0].getText()=="X"){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[1][2].getText()==""){
					board[1][2].setText(turn);
					board[1][2].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[1][2].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[2][0].getText()=="X"){
				if(board[0][0].getText()=="X" && board[1][0].getText()==""){
					board[1][0].setText(turn);
					board[1][0].setEnabled(false);
				}
				else if(board[0][0].getText()=="" && board[1][0].getText()=="X"){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[2][1].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[2][1].getText()=="" && board[2][2].getText()=="X"){
					board[2][1].setText(turn);
					board[2][1].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[0][2].getText()==""){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[0][2].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[0][1].getText()=="X"){
				if(board[0][0].getText()=="X" && board[0][2].getText()==""){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else if(board[0][0].getText()=="" && board[0][2].getText()=="X"){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[2][1].getText()==""){
					board[2][1].setText(turn);
					board[2][1].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[2][1].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[1][1].getText()=="X"){
				if(board[0][1].getText()=="X" && board[2][1].getText()==""){
					board[2][1].setText(turn);
					board[2][1].setEnabled(false);
				}
				else if(board[0][1].getText()=="" && board[2][1].getText()=="X"){
					board[0][1].setText(turn);
					board[0][1].setEnabled(false);
				}
				else if(board[1][0].getText()=="X" && board[1][2].getText()==""){
					board[1][2].setText(turn);
					board[1][2].setEnabled(false);
				}
				else if(board[1][0].getText()=="" && board[1][2].getText()=="X"){
					board[1][0].setText(turn);
					board[1][0].setEnabled(false);
				}
				else if(board[0][0].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[0][0].getText()=="" && board[2][2].getText()=="X"){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[0][2].getText()=="X" && board[2][0].getText()==""){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else if(board[0][2].getText()=="" && board[2][0].getText()=="X"){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[2][1].getText()=="X"){
				if(board[0][1].getText()=="X" && board[1][1].getText()==""){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else if(board[0][1].getText()=="" && board[1][1].getText()=="X"){
					board[0][1].setText(turn);
					board[0][1].setEnabled(false);
				}
				else if(board[2][0].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[2][0].getText()=="" && board[2][2].getText()=="X"){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[0][2].getText()=="X"){
				if(board[0][0].getText()=="X" && board[0][1].getText()==""){
					board[0][1].setText(turn);
					board[0][1].setEnabled(false);
				}
				else if(board[0][0].getText()=="" && board[0][1].getText()=="X"){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[1][2].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[1][2].getText()=="" && board[2][2].getText()=="X"){
					board[1][2].setText(turn);
					board[1][2].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[2][0].getText()==""){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[2][0].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[1][2].getText()=="X"){
				if(board[1][1].getText()=="X" && board[1][0].getText()==""){
					board[1][0].setText(turn);
					board[1][0].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[1][0].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else if(board[0][2].getText()=="X" && board[2][2].getText()==""){
					board[2][2].setText(turn);
					board[2][2].setEnabled(false);
				}
				else if(board[0][2].getText()=="" && board[2][2].getText()=="X"){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else if(board[2][2].getText()=="X"){
				if(board[2][1].getText()=="X" && board[2][0].getText()==""){
					board[2][0].setText(turn);
					board[2][0].setEnabled(false);
				}
				else if(board[2][1].getText()=="" && board[2][0].getText()=="X"){
					board[2][1].setText(turn);
					board[2][1].setEnabled(false);
				}
				else if(board[1][2].getText()=="X" && board[0][2].getText()==""){
					board[0][2].setText(turn);
					board[0][2].setEnabled(false);
				}
				else if(board[1][2].getText()=="" && board[0][2].getText()=="X"){
					board[1][2].setText(turn);
					board[1][2].setEnabled(false);
				}
				else if(board[1][1].getText()=="X" && board[0][0].getText()==""){
					board[0][0].setText(turn);
					board[0][0].setEnabled(false);
				}
				else if(board[1][1].getText()=="" && board[0][0].getText()=="X"){
					board[1][1].setText(turn);
					board[1][1].setEnabled(false);
				}
				else{
					found = 0;
					while(found == 0){
						r = rand.nextInt(3);
						c = rand.nextInt(3);
						if(board[r][c].getText()==""){
							board[r][c].setText(turn);
							board[r][c].setEnabled(false);
							found = 1;
						}
					}
				}
			}
			else{ //if start palang ng game.. and computer gets to go first since walang X sa board
				r = rand.nextInt(3);
				c = rand.nextInt(3);
				board[r][c].setText(turn);
				board[r][c].setEnabled(false);
			}
		}
	}
        
    public boolean GameOver(){
	//check perpendicular - vertical
		if(board[0][0].getText()!="" && board[0][0].getText() == board[1][0].getText() && board[1][0].getText() == board[2][0].getText())
			return true;
		else if(board[0][1].getText()!="" && board[0][1].getText() == board[1][1].getText() && board[1][1].getText() == board[2][1].getText())
			return true;
		else if(board[0][2].getText()!="" && board[0][2].getText() == board[1][2].getText() && board[1][2].getText() == board[2][2].getText())
			return true;
	//check perpendicular - horizontal
		else if(board[0][0].getText()!="" && board[0][0].getText() == board[0][1].getText() && board[0][1].getText() == board[0][2].getText())
			return true;
		else if(board[1][0].getText()!="" && board[1][0].getText() == board[1][1].getText() && board[1][1].getText() == board[1][2].getText())
			return true;
		else if(board[2][0].getText()!="" && board[2][0].getText() == board[2][1].getText() && board[2][1].getText() == board[2][2].getText())
			return true;
	//check diagonal
		else if(board[0][0].getText()!="" && board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText())
			return true;
		else if(board[0][2].getText()!="" && board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText())
			return true;

		return false;
	}
}