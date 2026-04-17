// Longest Prefix Suffix (LPS) - GeeksforGeeks
// Problem: https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1

class Solution {
    
    // ❌ BRUTE FORCE APPROACH - O(n²)
    // Check every possible prefix-suffix pair
    int getLPSLength_BruteForce(String s) {
        int n = s.length();
        int maxLen = 0;
        
        // Try all prefix lengths from 1 to n-1
        for (int len = 1; len < n; len++) {
            String prefix = s.substring(0, len);
            String suffix = s.substring(n - len);
            
            if (prefix.equals(suffix)) {
                maxLen = len;
            }
        }
        
        return maxLen;
    }
    
    // ✅ OPTIMAL APPROACH - O(n) using KMP LPS Array
    // Build LPS array and return last element
    int getLPSLength(String s) {
        int n = s.length();
        int[] lps = new int[n];
        
        int len = 0;      // length of previous longest prefix suffix
        int i = 1;        // pointer to traverse string
        
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                // ✅ MATCH: Characters match
                len++;
                lps[i] = len;
                i++;
            } else {
                // ❌ MISMATCH: Characters don't match
                if (len != 0) {
                    // Fallback to previous LPS value
                    len = lps[len - 1];
                } else {
                    // No prefix-suffix match found
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps[n - 1];  // Return LPS value of last character
    }
}

// Test Cases
class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println("=== Longest Prefix Suffix (LPS) ===\n");
        
        // Test 1
        String s1 = "aabcdabc";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.getLPSLength(s1));
        System.out.println("Expected: 4 (Prefix: 'aabc', Suffix: 'aabc')\n");
        
        // Test 2
        String s2 = "abab";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.getLPSLength(s2));
        System.out.println("Expected: 2 (Prefix: 'ab', Suffix: 'ab')\n");
        
        // Test 3
        String s3 = "aaaa";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + sol.getLPSLength(s3));
        System.out.println("Expected: 3\n");
        
        // Test 4
        String s4 = "abcde";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + sol.getLPSLength(s4));
        System.out.println("Expected: 0 (No matching prefix-suffix)\n");
        
        // Test 5
        String s5 = "ababab";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + sol.getLPSLength(s5));
        System.out.println("Expected: 4 (Prefix: 'abab', Suffix: 'abab')\n");
    }
}
