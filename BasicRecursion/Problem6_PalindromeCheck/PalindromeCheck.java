/**
 * Problem: Check if a string is a palindrome using recursion
 * 
 * Palindrome: A string that reads the same forward and backward
 * Examples: "hannah", "racecar", "a", "aba"
 * 
 * Approach: Two-pointer recursion (similar to reverse array)
 * 
 * Time Complexity: O(n) - checks n/2 character pairs
 * Space Complexity: O(n) - recursion call stack depth
 */
public class PalindromeCheck {
  
    public static boolean isPalindrome(String s) {
        return checkHelper(s, 0, s.length() - 1);
    }
  
    private static boolean checkHelper(String s, int left, int right) {
        if (left >= right) {
            return true;  // All characters matched!
        }
        
        // PART 2: CHECK - do characters at left and right match?
        if (s.charAt(left) != s.charAt(right)) {
            return false;  // Mismatch found! Not a palindrome
        }
        
        // RECURSIVE CALL - move pointers inward
        return checkHelper(s, left + 1, right - 1);
    }
     // Case-insensitive palindrome check
    public static boolean isPalindromeIgnoreCase(String s) {
        s = s.toLowerCase();
        return checkHelper(s, 0, s.length() - 1);
    }
    
    /**
     * Alphanumeric-only palindrome check
     * Ignores spaces, punctuation, etc.
     * Only considers letters and digits
     * 
     * @param s - String to check
     * @return true if palindrome (alphanumeric only), false otherwise
     */
    public static boolean isPalindromeAlphanumeric(String s) {
        s = s.toLowerCase()
             .replaceAll("[^a-z0-9]", "");  // Keep only alphanumeric
        return checkHelper(s, 0, s.length() - 1);
    }
    
    public static void main(String[] args) {
        // Test case 1: Simple palindrome
        System.out.println("Test 1: 'hannah'");
        System.out.println("Is palindrome? " + isPalindrome("hannah"));  // true
        System.out.println();
        
        // Test case 2: Not a palindrome
        System.out.println("Test 2: 'aabbaA'");
        System.out.println("Is palindrome? " + isPalindrome("aabbaA"));  // false (case-sensitive)
        System.out.println("Is palindrome (ignore case)? " + isPalindromeIgnoreCase("aabbaA"));  // true
        System.out.println();
        
        // Test case 3: Single character
        System.out.println("Test 3: 'a'");
        System.out.println("Is palindrome? " + isPalindrome("a"));  // true
        System.out.println();
        
        // Test case 4: With spaces and punctuation
        System.out.println("Test 4: 'A man, a plan, a canal: Panama'");
        System.out.println("Is palindrome (alphanumeric only)? " + 
                          isPalindromeAlphanumeric("A man, a plan, a canal: Panama"));  // true
    }
}
