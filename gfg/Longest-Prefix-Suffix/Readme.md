# 🔗 Longest Prefix Suffix (LPS)

## 📌 Problem Link
🔗 **GeeksforGeeks:** [Longest Prefix Suffix](https://www.geeksforgeeks.org/problems/longest-prefix-suffix2527/1)

---

## 📘 Problem Explanation

Given a string `s`, find the **length of the longest proper prefix which is also a suffix**.

### 🔹 Important Points:
- **Prefix ≠ whole string**
- **Suffix ≠ whole string**
- **Prefix and suffix should match**

### 🧠 Example:
Input: aabcdabc Output: 4

Explanation: Prefix: aabc
Suffix: aabc
Both match → Answer = 4

## 🚀 Approach

### **KMP Algorithm - LPS Array**
We use the **LPS (Longest Prefix Suffix)** array from the KMP algorithm.

**💡 Idea:**
- `lps[i]` = length of longest prefix == suffix for substring `0 → i`
- Build LPS array step by step
- Time: **O(n)** | Space: **O(n)**

---

## 📊 Example Walkthrough

String: a a b c d a a b c Index: 0 1 2 3 4 5 6 7 8

LPS: 0 1 0 0 0 1 2 3 4


---

## 💻 Implementation Files

| File | Purpose |
|------|---------|
| `LongestPrefixSuffix.java` | Brute Force & Optimal Solutions |
| `CodeExplanation.md` | Detailed Algorithm Walkthrough |

---

## 🧩 Key Insight

**Instead of rechecking substrings again and again, we reuse previous results using the LPS array → this is why KMP is efficient!**


👉 Final Answer = lps[n-1] = 4
