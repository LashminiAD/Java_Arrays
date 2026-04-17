Longest Prefix Suffix (LPS)
🔗 Problem Link

👉 GeeksforGeeks problem:
https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1

📘 Problem Explanation

Given a string s, find the length of the longest proper prefix which is also a suffix.

🔹 Important Points:
Prefix ≠ whole string
Suffix ≠ whole string
Prefix and suffix should match
🧠 Example:
Input:  aabcdabc
Output: 4

Explanation:
Prefix: aabc  
Suffix: aabc  
🚀 Approach (KMP Algorithm - LPS Array)

We use the LPS (Longest Prefix Suffix) array from the KMP algorithm.

💡 Idea:
lps[i] = length of longest prefix == suffix for substring 0 → i
Build LPS array step by step
🔍 Code Explanation
🔹 Variables:
lps[] → stores prefix-suffix lengths
len → length of previous longest prefix suffix
i → pointer to traverse string
🔹 Logic:
Start from i = 1
Compare s[i] with s[len]
✅ Case 1: Match
s[i] == s[len]
Increase len
Store in lps[i]
Move i++
❌ Case 2: Mismatch
If len != 0
len = lps[len - 1]

➡️ Try smaller prefix

If len == 0
lps[i] = 0
i++
💻 Code (Java)
class Solution {
    int getLPSLength(String s) {
        int n = s.length();
        int lps[] = new int[n];
        
        int len = 0;
        int i = 1;
        
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps[n - 1];
    }
}
📊 Example Walkthrough
String: a a b c d a a b c
Index:  0 1 2 3 4 5 6 7 8

LPS:    0 1 0 0 0 1 2 3 4

👉 Final Answer = lps[n-1] = 4

⏱️ Complexity
Time: O(n)
Space: O(n)
🧩 Key Insight

Instead of rechecking substrings again and again,
we reuse previous results using the LPS array → this is why KMP is efficient.
