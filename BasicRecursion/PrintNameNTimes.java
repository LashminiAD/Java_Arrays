public class PrintNameNTimes {
    /**
     * Prints "Lashmini" n times using recursion
     * 
     * Time Complexity: O(n) - makes n recursive calls
     * Space Complexity: O(n) - recursion call stack depth
     */
    static void printName(int n) {
        // Base case - stops recursion
        if (n == 0) {
            return;
        }

        // Work - print the name
        System.out.println("Lashmini");

        // Recursive call - reduce problem size by 1
        printName(n - 1);
    }

    public static void main(String[] args) {
        int n = 5;
        printName(n);
    }
}