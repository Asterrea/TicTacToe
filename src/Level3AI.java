public class Level3AI {

	private int board[][];
	public static int EMPTY = 0;
	public static int PLAYERONE = 1;
	public static int PLAYERTWO = 2;

	public Level3AI() {
		board = new int[3][3];
	}

	/* get the board value for position (i,j) */
	public int getBoard(int i, int j) {
		if (i < 0 || i >= 3)
			return EMPTY;
		if (j < 0 || j >= 3)
			return EMPTY;
		return board[i][j];
	}

	/* set the board value for position (i,j) */
	public void setBoard(int i, int j, int turnChar) {
		if (i < 0 || i >= 3)
			return;
		if (j < 0 || j >= 3)
			return;
		board[i][j] = turnChar;
	}

	/* calculate the winning move for current turnChar */
	public int[] nextWinningMove(int turnChar) {

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (getBoard(i, j) == EMPTY) {
					board[i][j] = turnChar;
					boolean win = isWin(turnChar);
					board[i][j] = EMPTY;
					if (win)
						return new int[] { i, j };
				}

		return null;
	}

	public int inverse(int turnChar) {
		return turnChar == PLAYERONE ? PLAYERTWO : PLAYERONE;
	}

	/* calculate the best move for current turnChar */
	public int[] possibleMoveFor(int turnChar) {

		if (getBoard(1, 1) == EMPTY)
			return new int[] { 1, 1 };

		int winMove[] = nextWinningMove(turnChar);
		if (winMove != null)
			return winMove;

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (getBoard(i, j) == EMPTY) {
					board[i][j] = turnChar;
					boolean ok = nextWinningMove(inverse(turnChar)) == null;
					board[i][j] = EMPTY;
					if (ok)
						return new int[] { i, j };
				}

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (getBoard(i, j) == EMPTY)
					return new int[] { i, j };

		return null;
	}

	/* determine if current turnChar is win or not win */
	public boolean isWin(int turnChar) {
		final int DI[] = { -1, 0, 1, 1 };
		final int DJ[] = { 1, 1, 1, 0 };
		
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				if (getBoard(i, j) != turnChar)
					continue;
				for (int k = 0; k < 4; k++) {
					int ctr = 0;
					while (getBoard(i + DI[k] * ctr, j + DJ[k] * ctr) == turnChar)
						ctr++;

					if (ctr == 3)
						return true;
				}
			}
		return false;
	}
}
