import java.util.Scanner;

public class ZyPermutations {
   static int permutationCount = 0;

   public static void permuteString(String head, String tail) {
      char current;
      String newPermute;
      int len;
      int i;

      current = '?';
      len = tail.length();

      if (len <= 1) {
         ++permutationCount;
         System.out.println(permutationCount + ") " + head + tail);
      }
      else {
         for (i = len - 1; i >= 0; --i) {
            current = tail.charAt(i);           // Get next leading character
            newPermute = tail.substring(0, i) + tail.substring(i + 1);
                                                // Get the rest of the tail
            permuteString(head + current, newPermute);
         } 
      } 
   } 

   public static void main(String [] args) {
      final String PROMPT_STRING = "Enter a string to permute in reverse (<Enter> to exit): ";
      Scanner scnr = new Scanner(System.in);
      String input;

      // Get input and permute the string
      System.out.println(PROMPT_STRING);
      input = scnr.nextLine();

      while (input.length() > 0) {
         permutationCount = 0;
         permuteString("", input);
         System.out.println(PROMPT_STRING);
         input = scnr.nextLine();
      } 
      System.out.println("Done.");
      scnr.close();
   } 
} 