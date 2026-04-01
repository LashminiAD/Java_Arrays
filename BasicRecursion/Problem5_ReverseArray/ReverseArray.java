/**
 * Problem: Reverse an array in-place using recursion
 * 
 * Approach: Two-pointer technique
 * - Left pointer starts at beginning
 * - Right pointer starts at end
 * - Swap elements and move pointers inward
 * - Stop when pointers meet
 * 
 * Time Complexity: O(n) - swaps n/2 pairs
 * Space Complexity: O(n) - recursion call stack depth
 */
public class ReverseArray {
    public static void reverse(int[] arr, int n) {
        reverseHelper(arr, 0, n - 1);
    }
    private static void reverseHelper(int[] arr, int left, int right) {
        if (left >= right) {
            return;  // Array is now reversed!
        }
        
        // SWAP current elements
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        // RECURSIVE CALL - move pointers inward
        reverseHelper(arr, left + 1, right - 1);
    }
    
    /**
     * Alternative: Single-pointer approach
     * Uses only one pointer from start
     * Calculates corresponding end index
     */
    public static void reverseSinglePointer(int[] arr, int n) {
        reverseSingleHelper(arr, 0, n);
    }
    
    private static void reverseSingleHelper(int[] arr, int i, int n) {
        // BASE CASE: reached middle
        if (i >= n / 2) {
            return;
        }
        
        // SWAP: element at i with element at (n-i-1)
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;
        
        // RECURSIVE CALL
        reverseSingleHelper(arr, i + 1, n);
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.print("Original: ");
        printArray(arr1);
        reverse(arr1, arr1.length);
        System.out.print("Reversed: ");
        printArray(arr1);
        // Output: 5 4 3 2 1
        
        System.out.println();
        
        // Test case 2
        int[] arr2 = {1, 2, 1, 1, 5, 1};
        System.out.print("Original: ");
        printArray(arr2);
        reverse(arr2, arr2.length);
        System.out.print("Reversed: ");
        printArray(arr2);
        // Output: 1 5 1 1 2 1
    }
}
