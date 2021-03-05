import java.util.*;
import java.io.*;

public class USACO {
public static int bronze(String filename) throws FileNotFoundException {
	Scanner scan = new Scanner(new File(filename));
	Scanner line = new Scanner(scan.next());

	int rows = line.nextInt();
	int cols = line.nextInt();
	int elevation = line.nextInt();
	int instructions = line.nextInt();

	System.out.println(rows);
	System.out.println(cols);
	System.out.println(elevation);
	System.out.println(instructions);
	return -1;
}
public static long silver(String filename) throws FileNotFoundException {
	return -1;
}
}
