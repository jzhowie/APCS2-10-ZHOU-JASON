import java.util.*;
import java.io.*;
public class Maze {

	private char[][] maze;
	private boolean animate;
	private int sol;

	/*Constructor loads a maze text file, and sets animate to false by default.
	When the file is not found then:
	throw a FileNotFoundException

	You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
	'#' - Walls - locations that cannot be moved onto
	' ' - Empty Space - locations that can be moved onto
	'E' - the location of the goal (exactly 1 per file)
	'S' - the location of the start(exactly 1 per file)

	You may also assume the maze has a border of '#' around the edges.
	So you don't have to check for out of bounds!
	*/
	public Maze(String filename) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		ArrayList<String> bee = new ArrayList<String>();
		while (scan.hasNext()) {
			String nextline = scan.nextLine();
			if (nextline.isEmpty() != true) {
				nextline = nextline.substring(nextline.indexOf("#"), nextline.lastIndexOf("#") + 1);
				bee.add(nextline);
			}
		}
		maze = new char[bee.size()][bee.get(0).length()];
		for (int i = 0; i < bee.size(); i++) {
			maze[i] = bee.get(i).toCharArray();
		}
		animate = false;
	}

	private static String colorize(String s){
		s = s.replace("@", "\033[32m\033[49m@\033[0m");
		s = s.replace("#", "\033[37m\033[47m#\033[0m");
		s = s.replace("E", "\033[35m\033[49mE\033[0m");
		return s;
	}

	private void wait(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch (InterruptedException e) {
		}
	}

	public void setAnimate(boolean b) {
		animate = b;
	}

	public static void clearTerminal(){
		System.out.println("\033[2J"); //erase terminal
	}
	public static void gotoTop(){
		System.out.println("\033[1;1H"); //go to top left of screen
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				temp += maze[i][j];
			}
			if (i != maze.length - 1) temp += '\n';
		}
		return temp;
	}

	/*Wrapper Solve Function returns the helper function
	Note the helper function has the same name, but different parameters.
	Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
	*/
	public int solve(){
		if (animate) {
			clearTerminal();
		}

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == 'S') {
					return solve(i, j, 0);
				}
			}
		}
		return -1;
	}

	/*
	Recursive Solve function:

	A solved maze has a path marked with '@' from S to E.

	Returns the number of @ symbols from S to E when the maze is solved,
	Returns -1 when the maze has no solution.

	Postcondition:
	The 'S' is replaced with '@'
	The 'E' remain the same
	All visited spots that were not part of the solution are changed to '.'
	All visited spots that are part of the solution are changed to '@'
	*/
	private int solve(int row, int col, int counter) {
		if(animate) {
			gotoTop();
			System.out.println(colorize(this.toString()));
			wait(50);
		}
		if (maze[row][col] == 'E') {
			sol = counter;
			return sol;
		}
		else if (maze[row][col] == '#' || maze[row][col] == '@' || maze[row][col] == '.') {
			return -1;
		}
		else {
			maze[row][col] = '@';
			if (solve(row + 1, col, counter + 1) > 0 || solve(row - 1, col, counter + 1) > 0 || solve(row, col + 1, counter + 1) > 0 || solve(row, col - 1, counter + 1) > 0) {
				return sol;
			}
			maze[row][col] = '.';

		}
		return -1;
	}
}
