public class QueenBoard {
	private int[][] board;
	private int QUEEN = -1;

	private boolean addQueen(int r, int c) {
		if (board[r-1][c-1] != 0) {
			return false;
		}
		else {
			board[r-1][c-1] = QUEEN;
			for (int i = c; i < board[r-1].length; i++) {
				board[r-1][i]++;
			}

			int diagonals = r;
			for (int i = c; diagonals < board.length && i < board[r-1].length; i++) {
				board[diagonals][i]++;
				diagonals++;
			}

			diagonals = r - 2;
			for (int i = c; diagonals > -1 && i < board[r-1].length; i++) {
				board[diagonals][i]++;
				diagonals--;
			}
			return true;
		}
	}

	private void removeQueen(int r, int c) {
		board[r-1][c-1] = 0;
		for (int i = c; i < board[r-1].length; i++) {
			board[r-1][i]--;
		}

		int diagonals = r;
		for (int i = c; diagonals < board.length && i < board[r-1].length; i++) {
			board[diagonals][i]--;
			diagonals++;
		}

		diagonals = r - 2;
		for (int i = c; diagonals > -1 && i < board[r-1].length; i++) {
			board[diagonals][i]--;
			diagonals--;
		}
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == QUEEN) temp += "Q";
				else temp += "_";

				if (j != board.length - 1) temp += " ";
			}
			temp += '\n';
		}
		return temp;
	}

	public boolean solve() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException();
				}
			}
		}

		return solve(0, 0);
	}

	private boolean solve(int row, int col) {
		if (col > board.length) return true;
		else {
			if ((row == 0 && col == 0) || addQueen(row, col)) {
				for (int i = 1; i < board.length + 1; i++) {
					if (solve(i, col+1)) return true;
				}
				if (row == 0 && col == 0) {
					board = new int[board.length][board.length];
					return false;
				}
				removeQueen(row, col);
			}
			return false;
		}
	}

	public int countSolutions() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					throw new IllegalStateException();
				}
			}
		}

		return countSolutions(0, 0);
	}

	private int countSolutions(int row, int col) {
		int counter = 0;
		if (col > board.length) counter++;
		else {
			if ((row == 0 && col == 0) || addQueen(row, col)) {
				for (int i = 1; i < board.length + 1; i++) {
					if (i == 1 || col+1 <= board.length) {
						counter += countSolutions(i, col+1);
					}
				}
				if (row == 0 && col == 0) {
					board = new int[board.length][board.length];
					return counter;
				}
				removeQueen(row, col);
			}
		}
		return counter;
	}

	public QueenBoard(int size) {
		board = new int[size][size];
	}
}
