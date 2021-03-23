import java.util.*;
public class Calculator {
public static double eval(String s) {
	String[] splited = s.split("\\s+");
	ArrayDeque<Double> calc = new ArrayDeque<Double>();
	for (String g : splited) {
		// System.out.println(g);
		try {
			Double temp = Double.parseDouble(g);
		}
		catch (Exception NumberFormatException) {
			if (g.equals("+")) return 1;
			else if (g.equals("-")) return 1;
			else if (g.equals("*")) return 1;
			else if (g.equals("/")) return 1;
			else if (g.equals("%")) return 1;
		}
	}
	return -1;
}
}
