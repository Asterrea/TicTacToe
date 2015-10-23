import javax.swing.JOptionPane;


public class Welcome extends JOptionPane{

	public Welcome(){
		int n = 0;
		String player = null;
		String nLevel = null;
		
		Object[] options = {"I'd like to start first!" , "You're good, You start."};
		Object[] levels = {"Level 1", "Level 2", "Level 3", "Level 4"};
		
		do{
			player = JOptionPane.showInputDialog(null, "Player Name:");
		}while(player.isEmpty());
		
		if(!player.isEmpty()){
			n = JOptionPane.showOptionDialog(null, player + ", would you like to have your turn first?",null, 
					JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
				
			nLevel = (String)JOptionPane.showInputDialog(null, "Choose opponent difficulty.", null, 
					JOptionPane.PLAIN_MESSAGE, icon, levels, "Level 1");
		}
	}
}
