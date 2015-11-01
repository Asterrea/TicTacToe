import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	                if (e.getSource() == board[row][col]){
	                    board[row][col].setText(turn);
	                    board[row][col].setEnabled(false);
	                    Play();
	                }
	            }
	        }
        }
    }
	
	public void Play(){
		
        curr = turn; //get the current player

        //switch player
        if(turn.equals("X"))
                turn = "O";
        else
                turn = "X";

        if(GameOver(row,col)){
                JOptionPane.showMessageDialog(null, "Player " + curr + " won!", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);
        }
    }
        
    public boolean GameOver(int rMove, int cMove){
	//check perpendicular
		if(board[0][cMove].getText().equals(board[1][cMove].getText()) && board[0][cMove].getText().equals(board[2][cMove].getText()))
			return true;
		else if(board[rMove][0].getText().equals(board[rMove][1].getText()) && board[rMove][0].getText().equals(board[rMove][2].getText()))
			return true;
	//check diagonal
        else if(board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText()) && !(board[1][1].getText().equals("")))
			return true;
        else if(board[0][2].getText().equals(board[1][1].getText()) && board[0][2].getText().equals(board[2][0].getText()) && !(board[1][1].getText().equals("")))
			return true;

		return false;
	}

    public static void main(String[] args){
        TicTacToe2 t2 = new TicTacToe2();
	}
}