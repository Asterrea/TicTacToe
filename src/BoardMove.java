
public class BoardMove {
	private int turn;

	public BoardMove(int turn) {
		// TODO Auto-generated constructor stub
		this.turn = turn;
	}

	
	public int nextTurn(){
		if(this.turn == 0)return 1;
		else if (this.turn == 1) return 0;
		return turn;
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
	 
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
}
