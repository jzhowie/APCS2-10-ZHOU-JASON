import java.util.*;
import java.io.*;

public class USACO {
public static int bronze(String filename) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(filename));
	Scanner line = new Scanner(scan.nextLine());

	int rows = line.nextInt();
	int cols = line.nextInt();
	int elevation = line.nextInt();
	int instructions = line.nextInt();

	int[][] field = new int[rows][cols];

	for (int i = 0; i < rows; i++) {
		line = new Scanner(scan.nextLine());
		for (int j = 0; j < cols; j++) {
			field[i][j] = line.nextInt();
		}
	}

	for (int i = 0; i < instructions; i++) {
		line = new Scanner(scan.nextLine());
		int row_s = line.nextInt();
		int col_s = line.nextInt();
		int smash = line.nextInt();
		field = bronzeHelper (row_s, col_s, smash, field);
	}

	int totalDepth = 0;
	for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
			if (elevation - field[i][j] > 0) {
				totalDepth = totalDepth + (elevation - field[i][j]);
			}
		}
	}
	return totalDepth * 72 * 72;
}

private static int[][] bronzeHelper(int row, int col, int depth, int[][] board) {
	int[] coords = {row - 1, col - 1};
	for (int i = row - 1; i < row + 2; i++) {
		for (int j = col - 1; j < col + 2; j++) {
			if (board[i][j] > board[coords[0]][coords[1]]) {
				coords = new int[] {i, j};
			}
		}
	}

	board[coords[0]][coords[1]] -= depth;
	for (int i = row - 1; i < row + 2; i++) {
		for (int j = col - 1; j < col + 2; j++) {
			if (board[i][j] > board[coords[0]][coords[1]]) {
				board[i][j] = board[coords[0]][coords[1]];
			}
		}
	}
	return board;
}

public static void printArr(int[][] arr) {
	for (int i = 0; i < arr.length; i++) {
		System.out.println(Arrays.toString(arr[i]));
	}
	System.out.println();
}

public static void printArr(long[][][] arr) {
	for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr[i].length; j++) {
			System.out.println(Arrays.toString(arr[i][j]));
		}
		System.out.println();
	}
	System.out.println();
}

public static long silver(String filename) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(filename));
	Scanner line = new Scanner(scan.nextLine());

	int rows = line.nextInt();
	int cols = line.nextInt();
	int time = line.nextInt();
	long[][][] field = new long[time+1][rows][cols];

	for (int i = 0; i < rows; i++) {
		line = new Scanner(scan.nextLine());
		String temp = line.next();
		for (int j = 0; j < temp.length(); j++) {
			if (temp.charAt(j) == '*') {
				for (int sec = 0; sec < time; sec++) {
					field[sec][i][j] = -1;
				}
			}
		}
	}

	line = new Scanner(scan.nextLine());
	int startR = line.nextInt();
	int startC = line.nextInt();
	int endR = line.nextInt();
	int endC = line.nextInt();

	field[0][startR-1][startC-1] = 1;
	for (int sec = 0; sec < time; sec++) {
		for (int row_t = 0; row_t < rows; row_t++) {
			for (int col_t = 0; col_t < cols; col_t++) {
				long temp = silverHelper(row_t, col_t, field[sec]);
				if (temp > 0) {
					field[sec+1][row_t][col_t] = temp;
				}
			}
		}
	}
	return field[time][endR-1][endC-1];
}

public static long silverHelper(int row, int col, long[][] board) {
	long counter = 0;
	if (board[row][col] == -1) {
		return -1;
	}
	if (board[row][col] != 0) {
		return 0;
	}
	if (col+1 < board[0].length && board[row][col+1] != -1) {
		counter += board[row][col+1];
	}
	if (col-1 >= 0 && board[row][col-1] != -1) {
		counter += board[row][col-1];
	}
	if (row-1 >= 0 && board[row-1][col] != -1) {
		counter += board[row-1][col];
	}
	if (row+1 < board.length && board[row+1][col] != -1) {
		counter += board[row+1][col];
	}
	return counter;
}
}
