public class Recursion {
  public static void main(String[] args) {
    String reverseTest = "Kalinka";
    if (reverseTest.equals(reverse(reverse(reverseTest)))) {
      System.out.println("Reverse Test: OK");
    }
  }

  public static String reverse(String s) {
    if (s.length() == 0) return s;
    return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length()-1));
  }

  public static long countNoDoubleLetterWords(int length, String word) {
    return (long)0.0; //placeholder
  }

  public static double sqrt(double n) {
    return 0.0; //placeholder
  }
}
