import java.util.*;
public class Calculator {
public static double eval(String s) {
	String[] splited = s.split("\\s+");
	ArrayDeque<Double> calc = new ArrayDeque<Double>();
	for (String g : splited) {
		System.out.println(g);
		try {
			Double temp = Double.parseDouble(g);
			calc.addLast(temp);
		}
		catch (Exception NumberFormatException) {
			System.out.println(calc.toString());
			if (g.equals("+")) calc.addLast(calc.removeLast() + calc.removeLast());
			else if (g.equals("-")) calc.addLast(calc.removeLast() - calc.removeLast());
			else if (g.equals("*")) calc.addLast(calc.removeLast() * calc.removeLast());
			else if (g.equals("/")) calc.addLast(calc.removeLast() / calc.removeLast());
			else if (g.equals("%")) calc.addLast(calc.removeLast() % calc.removeLast());
		}
	}
	return calc.getLast();
}
}
