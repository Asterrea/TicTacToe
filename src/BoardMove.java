import java.util.Random;


public class BoardMove {
	private int turn;
	private String computerChar;
	
	public BoardMove(){
		
	}
	public BoardMove(int turn, String computer_char) {

		this.turn = turn;
		this.computerChar = computer_char;
	}

	
	public int nextTurn(){
		if(this.turn == 0)return 1;
		else if (this.turn == 1) return 0;
		return turn;
	}
	
	public void computerPlay(String level, Board b){
		
		switch(level){
			case "Level 0":{

				Random rnd = new Random();
				int randomMove = rnd.nextInt(9-1 +1) + 1;
					switch(randomMove){
					case 1:{
						if(b.label1.isEnabled()){
							b.label1.setText(computerChar);
							b.label1.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 2:{
						if(b.label2.isEnabled()){
							b.label2.setText(computerChar);
							b.label2.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 3:{
						if(b.label3.isEnabled()){
							b.label3.setText(computerChar);
							b.label3.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 4:{
						if(b.label4.isEnabled()){
							b.label4.setText(computerChar);
							b.label4.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 5:{
						if(b.label5.isEnabled()){
							b.label5.setText(computerChar);
							b.label5.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 6:{
						if(b.label6.isEnabled()){
							b.label6.setText(computerChar);
							b.label6.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 7:{
						if(b.label7.isEnabled()){
							b.label7.setText(computerChar);
							b.label7.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 8:{
						if(b.label8.isEnabled()){
							b.label8.setText(computerChar);
							b.label8.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
					case 9:{
						if(b.label9.isEnabled()){
							b.label9.setText(computerChar);
							b.label9.setEnabled(false);
						}else {
							computerPlay(level, b);
						}
					}break;
				}
			}break;
			case "Level 1":{
				//call method for level 1
				//TicTacToe2 tic = new TicTacToe2();
			}break;
			case "Level 2":{
				//call method for level 2
			}
			case "Level 3":{
				//call method for level 3

			}
		}
	}

	boolean isGameOver(Board b){
	    	if(!b.label1.isEnabled() && !b.label2.isEnabled() && !b.label3.isEnabled() && 
	    			(b.label1.getText().equals(b.label2.getText()) && b.label1.getText().equals(b.label3.getText())))
	    		return true;
	    	else if(!b.label4.isEnabled() && !b.label5.isEnabled() && !b.label6.isEnabled() &&
	    			(b.label4.getText().equals(b.label5.getText()) && b.label4.getText().equals(b.label6.getText())))
	    		return true;
	    	else if(!b.label7.isEnabled() && !b.label8.isEnabled() && !b.label9.isEnabled() &&
	    			(b.label7.getText().equals(b.label8.getText()) && b.label7.getText().equals(b.label9.getText())))
	    		return true;
	    	else if(!b.label1.isEnabled() && !b.label4.isEnabled() && !b.label7.isEnabled() &&
	    			(b.label1.getText().equals(b.label4.getText()) && b.label1.getText().equals(b.label7.getText())))
	    		return true;
	    	else if(!b.label2.isEnabled() && !b.label5.isEnabled() && !b.label8.isEnabled() &&
	    			(b.label2.getText().equals(b.label5.getText()) && b.label2.getText().equals(b.label8.getText())))
	    		return true;
	    	else if(!b.label3.isEnabled() && !b.label6.isEnabled() && !b.label9.isEnabled() &&
	    			(b.label3.getText().equals(b.label6.getText()) && b.label3.getText().equals(b.label9.getText())))
	    		return true;
	    	
	    	else if(!b.label1.isEnabled() && !b.label5.isEnabled() && !b.label9.isEnabled() &&
	    			(b.label1.getText().equals(b.label5.getText()) && b.label1.getText().equals(b.label9.getText())))
	    		return true;
	    	else if(!b.label3.isEnabled() && !b.label5.isEnabled() && !b.label7.isEnabled() &&
	    			(b.label3.getText().equals(b.label5.getText()) && b.label3.getText().equals(b.label7.getText())))
	    		return true;
	    	
			return false;
	    	
	    }
	
	
	 public String getComputerChar() {
		return computerChar;
	}


	public void setComputerChar(String computerChar) {
		this.computerChar = computerChar;
	}
	 
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
}
