//TODO:
import java.util.*;
public class MazeGenerator {
public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
	if (startrow == 0 || startrow == maze.length - 1 || startcol == 0 || startcol == maze[0].length - 1) return;
	if (adjacent(maze, startrow, startcol) > 1) return;

	maze[startrow][startcol] = ' ';

	ArrayList<Character> directions = new ArrayList<Character>(Arrays.asList(new Character[] {'n', 's', 'e', 'w'}));
	Collections.shuffle(directions);
	System.out.println(directions.toString());
	for (int i = 0; i < directions.size(); i++) {
		if (directions.get(i) == 'n') generate(maze, 0, 0, startrow - 1, startcol);
		else if (directions.get(i) == 's') generate(maze, 0, 0, startrow + 1, startcol);
		else if (directions.get(i) == 'e') generate(maze, 0, 0, startrow, startcol + 1);
		else if (directions.get(i) == 'w') generate(maze, 0, 0, startrow, startcol - 1);
	}
}

public static void generateAmazing(char[][] maze, int rows, int cols, int startrow, int startcol, char direction) {
	double randomness = 0.300; // Randomness parameter, lower it to make more straight, raise it to make less straight

	if (startrow == 0 || startrow == maze.length - 1 || startcol == 0 || startcol == maze[0].length - 1) return;
	if (adjacent(maze, startrow, startcol) > 1) return;

	maze[startrow][startcol] = ' ';

	if (direction == 'e' && Math.random() >= randomness) generateAmazing(maze, 0, 0, startrow, startcol + 1, 'e');
	if (direction == 'w' && Math.random() >= randomness) generateAmazing(maze, 0, 0, startrow, startcol - 1, 'w');
	if (direction == 's' && Math.random() >= randomness) generateAmazing(maze, 0, 0, startrow + 1, startcol, 's');
	if (direction == 'n' && Math.random() >= randomness) generateAmazing(maze, 0, 0, startrow - 1, startcol, 'n');

	else {
		ArrayList<Character> directions = new ArrayList<Character>(Arrays.asList(new Character[] {'n', 's', 'e', 'w'}));
		Collections.shuffle(directions);
		for (int i = 0; i < directions.size(); i++) {
			if (directions.get(i) == 'n') generateAmazing(maze, 0, 0, startrow - 1, startcol, 'n');
			else if (directions.get(i) == 's') generateAmazing(maze, 0, 0, startrow + 1, startcol, 's');
			else if (directions.get(i) == 'e') generateAmazing(maze, 0, 0, startrow, startcol + 1, 'e');
			else if (directions.get(i) == 'w') generateAmazing(maze, 0, 0, startrow, startcol - 1, 'w');
		}
	}
}

private static int adjacent(char[][] maze, int row, int col) {
	int counter = 0;
	if (maze[row+1][col] == ' ') {
		counter++;
	}
	if (maze[row-1][col] == ' ') {
		counter++;
	}
	if (maze[row][col+1] == ' ') {
		counter++;
	}
	if (maze[row][col-1] == ' ') {
		counter++;
	}
	return counter;
}

public static String toString(char[][] maze) {
	String temp = "";
	for (int i = 0; i < maze.length; i++) {
		for (int j = 0; j < maze[i].length; j++) {
			temp += maze[i][j];
		}
		if (i != maze.length - 1) temp += '\n';
	}
	return colorize(temp);
}

private static String colorize(String s){
	s = s.replace("@", "\033[32m\033[49m@\033[0m");
	s = s.replace("#", "\033[37m\033[47m#\033[0m");
	s = s.replace("E", "\033[35m\033[49mE\033[0m");
	return s;
}

}
