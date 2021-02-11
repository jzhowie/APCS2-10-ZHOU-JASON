// TODO: solve(), countSolutions()
// https://konstantinnovation.github.io/apcs.html#20210210
// ISSUES: TBD
public class QueenBoard {

private int[][] board;
private int QUEEN = -1;

public boolean addQueen(int r, int c) { //remember to switch back
	// CONDITIONS FOR FALSE: SQUARE IS != 0
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

public void removeQueen(int r, int c) { // remember to switch back
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

public QueenBoard(int size) {
	board = new int[size][size];
}

public int[][] get() { // tester
	return board;
}
}
