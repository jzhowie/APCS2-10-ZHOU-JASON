//TODO: Everything
//ISSUES:
//NOTES:

import java.util.*;
import java.io.*;
public class Maze {

private char[][] maze;
private boolean animate;        //false by default

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
	//only clear the terminal if you are running animation
	if (animate) {
		clearTerminal();
	}

	for (int i = 0; i < maze.length; i++) {
		for (int j = 0; j < maze[i].length; j++) {
			if (maze[i][j] == 'S') return solve(i, j, 0);
		}
	}
	//start solving at the location of the s.
	//return solve(???,???);
	return 0;
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
		System.out.println(this);
		wait(50);
	}

	if (maze[row][col] == 'E') return counter;
	else if (maze[row][col] == '#') return 0;
	else if (maze[row][col] == '@') return 0;
	else {
		maze[row][col] = '@';
		solve(row + 1, col, counter + 1);
		solve(row - 1, col, counter + 1);
		solve(row, col + 1, counter + 1);
		solve(row, col - 1, counter + 1);
	}

	//COMPLETE SOLVE
	return -1;     //so it compiles
}
}
