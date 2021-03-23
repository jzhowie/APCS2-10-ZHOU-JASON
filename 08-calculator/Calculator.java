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
			Double temp = calc.removeLast();
			if (g.equals("+")) calc.addLast(calc.removeLast() + temp);
			else if (g.equals("-")) calc.addLast(calc.removeLast() - temp);
			else if (g.equals("*")) calc.addLast(calc.removeLast() * temp);
			else if (g.equals("/")) calc.addLast(calc.removeLast() / temp);
			else if (g.equals("%")) calc.addLast(calc.removeLast() % temp);

		}
	}
	return calc.getLast();
}
}
