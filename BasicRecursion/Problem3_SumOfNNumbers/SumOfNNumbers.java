public class SumOfNNumbers {
    public static int sumOfNNumbers(int n) {)
        if (n == 0) {
            return 0;
        }
              
        // sum(n) = n + sum(n-1)
        return n + sumOfNNumbers(n - 1);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Sum of 1 to 4: " + sumOfNNumbers(4));   // 10
        System.out.println("Sum of 1 to 5: " + sumOfNNumbers(5));   // 15
        System.out.println("Sum of 1 to 0: " + sumOfNNumbers(0));   // 0
        System.out.println("Sum of 1 to 1: " + sumOfNNumbers(1));   // 1
    }
}
/**
 * Problem: Find the sum of first N natural numbers using recursion
 * 
 * Formula: sum(n) = n + sum(n-1)
 * 
 * Time Complexity: O(n) - makes n recursive calls
 * Space Complexity: O(n) - recursion call stack depth
 */
