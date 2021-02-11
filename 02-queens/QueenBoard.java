// TODO: toString(), solve(), countSolutions(), add & remove Queen()
// https://konstantinnovation.github.io/apcs.html#20210210
// ISSUES: TBD
public class QueenBoard {

private int[][] board;
private int QUEEN = -1;

public boolean addQueen(int r, int c) { //remember to switch back
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

public QueenBoard(int size) {
	board = new int[size][size];
}

public int[][] get() { // tester
	return board;
}
}
