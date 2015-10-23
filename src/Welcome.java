import javax.swing.JOptionPane;


public class Welcome extends JOptionPane{

	public Welcome(){
		String player = JOptionPane.showInputDialog(null, "Player Name:");
		Object[] options = {"I'd like to start first!" , "You're good, You start."};
		Object[] levels = {"Level 1", "Level 2", "Level 3", "Level 4"};
		
		int n = JOptionPane.showOptionDialog(null, player + ", would you like to have your turn first?",null, JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		String nLevel = (String)JOptionPane.showInputDialog(null, player +", choose opponent difficulty.", null, JOptionPane.PLAIN_MESSAGE, icon, 
				levels, "Level 1");
		
		System.out.println(n);
		System.out.println(nLevel);
	}
}
