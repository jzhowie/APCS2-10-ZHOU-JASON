public class QueenBoard {

private int[][] board;
private int QUEEN = -1;

public QueenBoard(int size) {
	board = new int[size][size];
}

public int[][] get() { // tester
	return board;
}
}
