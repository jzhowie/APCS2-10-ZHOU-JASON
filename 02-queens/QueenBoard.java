// TODO: countSolutions()
// https://konstantinnovation.github.io/apcs.html#20210210
// ISSUES:

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
			if (board[i][j] == QUEEN) {
				temp += "Q ";
			}
			else {
				temp += "_ ";
			}
		}
		temp += '\n';
	}
	return temp;
}

public boolean solve() {
	return solver(0, 0);
}

private boolean solver(int row, int col) {
	if (col > board.length) return true;
	else {
		if ((row == 0 && col == 0) || addQueen(row, col)) {
			for (int i = 1; i < board.length + 1; i++) {
				if (solver(i, col+1)) {
					return true;
				}
			}
			if (row == 0 && col == 0) return false;
			removeQueen(row, col);
		}
		return false;
	}
}

public QueenBoard(int size) {
	board = new int[size][size];
}
}
