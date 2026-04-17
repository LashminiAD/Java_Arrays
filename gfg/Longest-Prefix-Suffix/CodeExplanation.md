# 🔍 Longest Prefix Suffix - Code Explanation

## 🎯 Algorithm Overview

The KMP LPS Array approach solves this in **O(n)** time by reusing previous computations instead of rechecking.

---

## 🔹 Key Variables

| Variable | Purpose |
|----------|---------|
| `lps[]` | Array storing longest prefix-suffix length for each position |
| `len` | Length of previous longest prefix-suffix match |
| `i` | Pointer traversing the string from index 1 |

---

## 🧠 Algorithm Logic

### **Step-by-Step Process:**

```
Initialize:
  lps[0] = 0  (first character has no prefix-suffix)
  len = 0
  i = 1

Loop from i = 1 to n-1:
  if s[i] == s[len]:
    ✅ MATCH FOUND
    len++
    lps[i] = len
    i++
  else:
    ❌ MISMATCH
    if len != 0:
      len = lps[len - 1]  (fallback to smaller match)
    else:
      lps[i] = 0
      i++
```

---

## 📊 Example Walkthrough: "aabcdabc"

### **String Visualization:**
```
String: a  a  b  c  d  a  a  b  c
Index:  0  1  2  3  4  5  6  7  8
```

### **Building LPS Array Step-by-Step:**

```
i=1: s[1]='a', s[0]='a' → MATCH
     len=1, lps[1]=1
     LPS so far: [0, 1, ?, ?, ?, ?, ?, ?, ?]

i=2: s[2]='b', s[1]='a' → MISMATCH
     len = lps[1-1] = lps[0] = 0
     s[2]='b', s[0]='a' → MISMATCH
     lps[2] = 0
     LPS so far: [0, 1, 0, ?, ?, ?, ?, ?, ?]

i=3: s[3]='c', s[0]='a' → MISMATCH
     lps[3] = 0
     LPS so far: [0, 1, 0, 0, ?, ?, ?, ?, ?]

i=4: s[4]='d', s[0]='a' → MISMATCH
     lps[4] = 0
     LPS so far: [0, 1, 0, 0, 0, ?, ?, ?, ?]

i=5: s[5]='a', s[0]='a' → MATCH
     len=1, lps[5]=1
     LPS so far: [0, 1, 0, 0, 0, 1, ?, ?, ?]

i=6: s[6]='a', s[1]='a' → MATCH
     len=2, lps[6]=2
     LPS so far: [0, 1, 0, 0, 0, 1, 2, ?, ?]

i=7: s[7]='b', s[2]='b' → MATCH
     len=3, lps[7]=3
     LPS so far: [0, 1, 0, 0, 0, 1, 2, 3, ?]

i=8: s[8]='c', s[3]='c' → MATCH
     len=4, lps[8]=4
     LPS so far: [0, 1, 0, 0, 0, 1, 2, 3, 4]
```

### **Final Result:**
```
LPS Array: [0, 1, 0, 0, 0, 1, 2, 3, 4]
Answer = lps[8] = 4

Prefix: aabc (indices 0-3)
Suffix: aabc (indices 5-8)
✅ Match Found!
```

---

## 🔄 Why the Fallback Works?

When we have a mismatch at position `i`:

```
len = lps[len - 1]  // Go to previous match length
```

**Example:**
```
Pattern: AABAAB
         A A B A A B

At i=3:
  s[3]='A', s[2]='B' → MISMATCH
  
Instead of going back to len=0, we use:
  len = lps[2] = 0
  
This avoids redundant comparisons!
```

---

## ⏱️ Complexity Analysis

| Aspect | Value |
|--------|-------|
| **Time Complexity** | O(n) - Single pass through string |
| **Space Complexity** | O(n) - LPS array storage |
| **Best Case** | O(n) - When pattern matches frequently |
| **Worst Case** | O(n) - Still linear with KMP |

---

## 💡 Key Insights

✅ **Why KMP is efficient:**
- No backtracking in the main string
- Reuse previous computations via LPS array
- Fallback mechanism avoids redundant checks

✅ **When to use LPS:**
- String matching problems
- Pattern searching with KMP algorithm
- Finding periodic patterns in strings
