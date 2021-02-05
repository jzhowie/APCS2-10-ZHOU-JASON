public class Recursion {
  public static void main(String[] args) {
    String reverseTest = "Kalinka";
    if (reverseTest.equals(reverse(reverse(reverseTest)))) {
      System.out.println("Reverse Test: OK");
    }
    System.out.println(countNoDoubleLetterWords(5, ""));
  }

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
    return 0.0; //placeholder
  }
}
