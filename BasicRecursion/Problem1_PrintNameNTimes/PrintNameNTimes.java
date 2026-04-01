public class PrintNameNTimes {
    static void printName(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Lashmini");
        printName(n - 1);
    }
    
    public static void main(String[] args) {
        int n = 5;
        printName(n);
    }
}
/**
 * Problem: Print a name N times using recursion
 * 
 * Time Complexity: O(n) - makes n recursive calls
 * Space Complexity: O(n) - recursion call stack depth
 */
