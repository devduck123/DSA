public class ValidPalindrome {
    public static void main (String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // amanaplanacanalpanama = palindrome = true

        // String s = "0P";      = false

        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome2(s));
    }

    /* 
    
    given a String s, determine if it is a
    palindrome, considering only alphanumeric
    characters and ignoring cases.
    
    NOTE: palindrome = values are the same in reverse

    */

    // brute-force approach (runtime=896MS, memory=546.8MB)
    public static boolean isPalindrome(String s) {
        //   put sanitized characters in a list
        //   { iterate list from start, 
        //     iterate list from end }
        //   simultaneously compare characters to be equal

        String validCharacters = "";
        
        // sanitize characters
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            // ASCII: A-Z = 65-90 | a-z = 97-122 | 0-9 = 48-57
            if ((curr >= 65 && curr <=90) || (curr >= 97 && curr <= 122) || (curr >= 48 && curr <= 57)) {
                validCharacters += curr;
            }
        }
        
        validCharacters = validCharacters.toLowerCase();

        // compare iterating from start & end
        int start = 0;
        int end = validCharacters.length()-1;
        while (start < validCharacters.length()) {
            if (validCharacters.charAt(start) != validCharacters.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // same approach, but the "Java" way (runtime=1065MS, memory=457.4MB)
    public static boolean isPalindrome2(String s) {
        String validCharacters = "";

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                validCharacters += c;
            }
        }

        validCharacters = validCharacters.toLowerCase();

        int start = 0;
        int end = validCharacters.length()-1;
        while (start <= end) {
            if (validCharacters.charAt(start) != validCharacters.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
