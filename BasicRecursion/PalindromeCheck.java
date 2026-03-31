public class PalindromeCheck {

    // Function to check if a string is a palindrome using recursion
    public static boolean isPalindrome(String str, int left, int right) {
        // Base case: if the left index is greater than or equal to the right index
        if (left >= right) {
            return true;
        }
        // Check characters and recurse
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String str = "radar";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println(str + " is a palindrome: " + result);
    }
}