
public class Factorial {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }  
      // f(n) = n × f(n-1)
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println("Factorial of 0: " + factorial(0));   // 1
        System.out.println("Factorial of 1: " + factorial(1));   // 1
        System.out.println("Factorial of 5: " + factorial(5));   // 120
        System.out.println("Factorial of 10: " + factorial(10)); // 3628800
    }
}

/**
 * Problem: Calculate factorial of N using recursion
 * 
 * Definition: n! = n × (n-1) × (n-2) × ... × 2 × 1
 *             0! = 1 (by definition)
 *             1! = 1
 * 
 * Formula: f(n) = n × f(n-1)
 * 
 * Time Complexity: O(n) - makes n recursive calls
 * Space Complexity: O(n) - recursion call stack depth
 */
