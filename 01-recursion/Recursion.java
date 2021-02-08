// import java.util.*;
// import java.text.DecimalFormat;

public class Recursion {
  // public static void main(String[] args) {
  //   int tests = 10000;
  //   String reverseTest = "Kalinka";
  //   if (reverseTest.equals(reverse(reverse(reverseTest)))) {
  //     System.out.println("Reverse Test: OK");
  //   }
  //   System.out.println(countNoDoubleLetterWords(3, ""));
  //   Random rng = new Random();
  //   DecimalFormat formatter = new DecimalFormat("0.0000000000");
  //   for (int i = 0; i < tests; i++) {
  //     double temp = rng.nextDouble();
  //     double error = Math.abs((sqrt(temp) - Math.sqrt(temp)) / Math.sqrt(temp));
  //     if (error > 0.000005) {
  //       System.out.println(temp);
  //     }
  //     formatter.format(error);
  //   }
  // }

  public static String reverse(String s) {
    if (s.length() == 0) return s;
    return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length()-1));
  }

  public static long countNoDoubleLetterWords(int length, String word) {
    if (length <= 0) {
  		return 1;
  	}
  	else {
      long counter = 0;
  		for (char i = 'a'; i <= 'z'; i++) {
  			if (word.length() < 1 || word.charAt(word.length() - 1) != i) {
  				counter += countNoDoubleLetterWords(length-1, word + i);
        }
		  }
    return counter;
	 }
  }


  public static double sqrt(double n) {
    if (n == 0) return 0;
    return sqrt(n, 1);
  }

  public static double sqrt(double n, double guess) {
    if (Math.abs(Math.pow(guess, 2)-n) / n <= 0.00001) {
      return guess;
    }
    else {
      return sqrt(n, (n / guess + guess) / 2);
    }
  }
}
