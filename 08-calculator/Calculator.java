import java.util.*;
public class Calculator {
	public static double eval(String s) {
		String[] splited = s.split("\\s+");
		if (splited.length < 1) throw new IllegalArgumentException("Empty string");
		ArrayDeque<Double> calc = new ArrayDeque<Double>();
		for (String g : splited) {
			try {
				Double temp = Double.parseDouble(g);
				calc.addLast(temp);
			}
			catch (Exception NumberFormatException) {
				if (calc.size() < 2) throw new IllegalArgumentException("Too few operands");
				Double temp = calc.removeLast();

				if (g.equals("+")) calc.addLast(calc.removeLast() + temp);
				else if (g.equals("-")) calc.addLast(calc.removeLast() - temp);
				else if (g.equals("*")) calc.addLast(calc.removeLast() * temp);
				else if (g.equals("/")) calc.addLast(calc.removeLast() / temp);
				else if (g.equals("%")) calc.addLast(calc.removeLast() % temp);
			}
		}
		if (calc.size() != 1) throw new IllegalArgumentException("Too many operands");
		return calc.getLast();
	}
}
