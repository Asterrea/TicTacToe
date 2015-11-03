import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Welcome extends JOptionPane{
	public Welcome(){
		String player;
		String nLevel = null;
		int n = 0;
		
		Object[] options = {"I'd like to start first!" , "You're good, You start."};
		Object[] levels = {"Level 0", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
		
		do{
			player = JOptionPane.showInputDialog(null, "Player Name:");
		}while(player.isEmpty());
		
		if(!player.isEmpty()){
			n = JOptionPane.showOptionDialog(null, player + ", would you like to have your turn first?",null, 
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
			nLevel = (String)JOptionPane.showInputDialog(null, "Choose opponent difficulty.", null, 
					JOptionPane.PLAIN_MESSAGE, icon, levels, "Level 0");
		}
		
		if(!player.isEmpty() && !nLevel.isEmpty() && n >= 0){
			JFrame frame = new JFrame();
			Board board;
			TicTacToe2  tic2;
			TicTacToe3 tic3 = new TicTacToe3(n);
			TicTacToe4 tic4;

			if(nLevel.equals("Level 1")) tic2 = new TicTacToe2();
			else if(nLevel.equals("Level 2")) tic4 = new TicTacToe4();
			else if(nLevel.equals("Level 3")) tic3.setVisible(true);
			else {
				board = new Board();
				board.showActionListenerBoard(player, nLevel , n);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.add(board);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		}
	}
}
