import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class TicTacToe3 extends JFrame implements ActionListener {

	private JButton[][] board = new JButton[3][3];

	private int player = 0, computer = 0;
	private boolean isNotOver = false;
	private String[] turnMoves = new String[] { "", "X", "O" };
	private int firstMove;

	private Level3AI ai = null;

	public TicTacToe3(int firstMove) {

		JPanel boardPanel = new JPanel(new GridLayout(3, 3));

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				board[i][j] = new JButton(" ");
				board[i][j].addActionListener(this);
				board[i][j].setFocusable(false);
				boardPanel.add(board[i][j]);
			}

		add(boardPanel);

		setSize(300, 300);
		setLocationRelativeTo(null);
		setBoard(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.firstMove = firstMove;

		Play();
	}

	// set board[][] available
	private void setBoard(boolean enabled) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				board[i][j].setEnabled(enabled);
				if (enabled)
					board[i][j].setText("");
			}
	}

	private void GameOver() {
		if (ai.isWin(player)) {
			setBoard(false);
			isNotOver = false;
			JOptionPane.showMessageDialog(null, "YOU WON!", "GAME OVER!",
					JOptionPane.PLAIN_MESSAGE);
		}
		if (ai.isWin(computer)) {
			JOptionPane.showMessageDialog(null, "YOU LOSE! COMPUTER WINS!",
					"GAME OVER!", JOptionPane.PLAIN_MESSAGE);
			setBoard(false);
			isNotOver = false;
		}
		if (ai.possibleMoveFor(player) == null && ai.possibleMoveFor(computer) == null) {
			JOptionPane.showMessageDialog(null, "IT'S A DRAW!", "GAME OVER!",
					JOptionPane.PLAIN_MESSAGE);
			setBoard(false);
			isNotOver = false;
		}
	}

	private void Play() {
		ai = new Level3AI();

		player = Level3AI.PLAYERONE;
		computer = Level3AI.PLAYERTWO;

		setBoard(true);
		isNotOver = true;

		if (firstMove == 1)
			computerMove();
	}

	// player gets board[i][j]
	private void playerMove(int i, int j) {
		if (ai.getBoard(i, j) == Level3AI.EMPTY) {
			board[i][j].setText(turnMoves[player]);
			ai.setBoard(i, j, player);
			GameOver();
			computerMove();
		}
	}

	// computer choose move & get board[i][j]
	private void computerMove() {
		if (!isNotOver)
			return;

		int[] bestPosition = ai.possibleMoveFor(computer);
		
		if (bestPosition != null) {
			int i = bestPosition[0];
			int j = bestPosition[1];
			board[i][j].setText(turnMoves[computer]);
			ai.setBoard(i, j, computer);
		}

		GameOver();
	}

	// after setting board[][] player choose move
	public void actionPerformed(ActionEvent event) {

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (event.getSource() == board[i][j])
					playerMove(i, j);

	}
}