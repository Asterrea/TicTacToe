
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
	
	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}
	
}
