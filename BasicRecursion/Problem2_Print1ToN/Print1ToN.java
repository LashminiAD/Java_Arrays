public class Print1ToN {
    
    public static void printNumbers(int n) {
        if (n == 0) {
            return;  
        }
        printNumbers(n - 1);
        //PRINT AFTER RECURSION (during backtracking)
        // This is the KEY difference! Print happens when coming back
        System.out.println(n);  
    }
    
    public static void main(String[] args) {
        int n = 5;
        printNumbers(n);
        // Output: 1, 2, 3, 4, 5 ✓
    }
}
/**
 * Problem: Print numbers from 1 to N in increasing order using recursion
 * 
 * Key Insight: Print AFTER recursion to get increasing order!
 * 
 * Time Complexity: O(n) - makes n recursive calls
 * Space Complexity: O(n) - recursion call stack depth
 */
