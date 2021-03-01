public class MazeGenerator {
public static void generate(char[][] maze, int rows, int cols, int startrow, int startcol) {
	if (startrow == 0 || startrow == maze.length - 1 || startcol == 0 || startcol == maze[0].length - 1) {
		return;
	}
	if (adjacent(maze, startrow, startcol) > 1) {
		return;
	}
	maze[startrow][startcol] = ' ';
	if (Math.random() >= 0.500) {
		generate(maze, 0, 0, startrow + 1, startcol);
		generate(maze, 0, 0, startrow - 1, startcol);
		generate(maze, 0, 0, startrow, startcol + 1);
		generate(maze, 0, 0, startrow, startcol - 1);
	}
	else {
		generate(maze, 0, 0, startrow, startcol + 1);
		generate(maze, 0, 0, startrow, startcol - 1);
		generate(maze, 0, 0, startrow + 1, startcol);
		generate(maze, 0, 0, startrow - 1, startcol);
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

public static String colorize(String s){
	s = s.replace("@", "\033[32m\033[49m@\033[0m");
	s = s.replace("#", "\033[37m\033[47m#\033[0m");
	s = s.replace("E", "\033[35m\033[49mE\033[0m");
	return s;
}

}
