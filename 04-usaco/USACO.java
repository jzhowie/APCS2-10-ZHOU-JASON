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
		System.out.println(Arrays.deepToString(arr[i]));
	}
	System.out.println();
}

public static long silver(String filename) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(filename));
	Scanner line = new Scanner(scan.nextLine());

	int rows = line.nextInt();
	int cols = line.nextInt();
	int time = line.nextInt();
	long[][][] field = new long[time][rows][cols];

	for (int i = 0; i < rows; i++) {
		line = new Scanner(scan.nextLine());
		String temp = line.next();
		for (int j = 0; j < temp.length(); j++) {
			if (temp.charAt(j) == '*') {
				field[0][i][j] = -1;
			}
		}
	}

	field[1][rows-1][cols-1] = 1;
	printArr(field);
	return -1;
}
}
