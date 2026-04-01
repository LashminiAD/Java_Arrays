# Problem 6: Palindrome Check

## Problem Statement
Given a string **s**, determine if it is a **palindrome** using recursion.

**Palindrome Definition:** A string that reads the same forward and backward.

**Examples:**
- Input: "hannah" → Output: true (reads same both ways)
- Input: "aabbaA" → Output: false (case-sensitive) / true (case-insensitive)
- Input: "racecar" → Output: true
- Input: "a" → Output: true (single character)
- Input: "ab" → Output: false

---

## Understanding the Problem

### What is a Palindrome?

```
"hannah" → Forward: h-a-n-n-a-h
           Backward: h-a-n-n-a-h
           Same! ✓

"hello" → Forward: h-e-l-l-o
          Backward: o-l-l-e-h
          Different ✗
```

### Visual Comparison

```
"racecar" (length 7)
 0 1 2 3 4 5 6 (indices)
 r a c e c a r

Compare:
- s[0] ('r') == s[6] ('r') ✓
- s[1] ('a') == s[5] ('a') ✓
- s[2] ('c') == s[4] ('c') ✓
- s[3] ('e') == s[3] ('e') ✓ (middle, automatically matches)

Result: Palindrome! ✓
```

### Key Insight: Use Two Pointers

```
Left pointer:  starts at index 0
Right pointer: starts at index length-1

Compare s[left] with s[right]
If all match → Palindrome ✓
If any mismatch → Not palindrome ✗
```

---

## Solution Explanation

### Complete Code

```java
public static boolean isPalindrome(String s) {
    return checkHelper(s, 0, s.length() - 1);
}

private static boolean checkHelper(String s, int left, int right) {
    // BASE CASE
    if (left >= right) {
        return true;
    }
    
    // CHECK
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    // RECURSIVE CALL
    return checkHelper(s, left + 1, right - 1);
}
```

### The 3 Parts

#### Part 1: BASE CASE
```java
if (left >= right) {
    return true;
}
```
- **What?** Pointers have met or crossed
- **Why?** All characters have been checked
- **Result?** Return true (palindrome confirmed)

#### Part 2: CHECK
```java
if (s.charAt(left) != s.charAt(right)) {
    return false;
}
```
- **What?** Compare characters at left and right
- **If mismatch?** Return false immediately (not a palindrome)
- **If match?** Continue to recursion

#### Part 3: RECURSIVE CALL
```java
return checkHelper(s, left + 1, right - 1);
```
- **What?** Move pointers inward
- **Why?** Check next pair of characters
- **Progress?** Pointers move toward center

---

## Step-by-Step Example: "hannah"

### Execution Trace

```
STRING: "hannah" (length 6)
INDEX:   0 1 2 3 4 5
CHARS:   h a n n a h

CALL 1: checkHelper(s, 0, 5)
  ├─ left=0, right=5
  ├─ 0 < 5, continue
  ├─ CHECK: s[0]='h', s[5]='h' → MATCH ✓
  └─ Call checkHelper(s, 1, 4)

CALL 2: checkHelper(s, 1, 4)
  ├─ left=1, right=4
  ├─ 1 < 4, continue
  ├─ CHECK: s[1]='a', s[4]='a' → MATCH ✓
  └─ Call checkHelper(s, 2, 3)

CALL 3: checkHelper(s, 2, 3)
  ├─ left=2, right=3
  ├─ 2 < 3, continue
  ├─ CHECK: s[2]='n', s[3]='n' → MATCH ✓
  └─ Call checkHelper(s, 3, 2)

CALL 4: checkHelper(s, 3, 2)
  ├─ left=3, right=2
  ├─ 3 >= 2, BASE CASE!
  └─ return true ✓

UNWINDING:
checkHelper(3, 2) returns: true
checkHelper(2, 3) returns: true
checkHelper(1, 4) returns: true
checkHelper(0, 5) returns: true ✓

FINAL RESULT: true (IS PALINDROME) ✓
```

### Call Stack

```
┌────────────────────────┐
│ checkHelper(s, 3, 2)   │ ← BASE CASE
│ checkHelper(s, 2, 3)   │ → checks (n, n)
│ checkHelper(s, 1, 4)   │ → checks (a, a)
│ checkHelper(s, 0, 5)   │ → checks (h, h)
└────────────────────────┘

Comparisons:
h == h ✓
a == a ✓
n == n ✓
(pointers cross, all checked)

Result: Palindrome! ✓
```

---

## Non-Palindrome Example: "hello"

### Execution Trace

```
STRING: "hello" (length 5)
INDEX:   0 1 2 3 4
CHARS:   h e l l o

CALL 1: checkHelper(s, 0, 4)
  ├─ left=0, right=4
  ├─ 0 < 4, continue
  ├─ CHECK: s[0]='h', s[4]='o'
  ├─ 'h' != 'o' → MISMATCH! ✗
  └─ return false ❌

FINAL RESULT: false (NOT A PALINDROME) ❌
```

**Why?** First characters don't match (h ≠ o), so immediately return false.

---

## Complexity Analysis

### Time Complexity: O(n)

```
For string of length n:
- Comparisons at each level: 1 (O(1))
- Maximum levels: n/2 (until pointers meet)
- Total: (n/2) × O(1) = O(n) ✓

Example: "hannah" (n=6)
Comparisons:
1. h == h ✓
2. a == a ✓
3. n == n ✓
4. (3 >= 2, stop)

Total: 3 comparisons = n/2 ✓
```

### Space Complexity: O(n)

```
Call stack depth:

For string "hannah" (n=6):
checkHelper(s, 0, 5)
  ├─ checkHelper(s, 1, 4)
  │   ├─ checkHelper(s, 2, 3)
  │       ├─ checkHelper(s, 3, 2)
  │           └─ BASE CASE

Depth: 4 = (6/2) + 1 ≈ O(n) ✓

General: Depth = (n/2) + 1 ≈ O(n)
Each frame: ~200 bytes (String ref, indices, return address)
```

---

## Alternative Solutions

### Solution 1: Iterative (Better Space)
```java
public static boolean isPalindromeIterative(String s) {
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    
    return true;
}

// Time: O(n) (same)
// Space: O(1) (much better!)
```

### Solution 2: Reverse and Compare
```java
public static boolean isPalindromeReverse(String s) {
    String reversed = new StringBuilder(s).reverse().toString();
    return s.equals(reversed);
}

// Time: O(n)
// Space: O(n) (for reversed string)
```

### Solution 3: Convert to Array
```java
public static boolean isPalindromeArray(String s) {
    char[] chars = s.toCharArray();
    int left = 0, right = chars.length - 1;
    
    while (left < right) {
        if (chars[left] != chars[right]) {
            return false;
        }
        left++;
        right--;
    }
    
    return true;
}

// Time: O(n)
// Space: O(n) (for char array)
```

### Comparison

| Approach | Time | Space | Notes |
|----------|------|-------|-------|
| Recursion | O(n) | O(n) | Educational |
| Iterative | O(n) | O(1) | ⭐ Best |
| Reverse | O(n) | O(n) | Simple but wasteful |
| Array | O(n) | O(n) | Similar to reverse |

---

## Variations: Case-Insensitive & Alphanumeric

### Variation 1: Case-Insensitive

```java
public static boolean isPalindromeIgnoreCase(String s) {
    s = s.toLowerCase();
    return checkHelper(s, 0, s.length() - 1);
}

isPalindromeIgnoreCase("Racecar");    // true ✓
isPalindromeIgnoreCase("Hannah");     // true ✓
isPalindromeIgnoreCase("aAbBaa");     // true ✓
```

### Variation 2: Alphanumeric Only (Ignore Spaces/Punctuation)

```java
public static boolean isPalindromeAlphanumeric(String s) {
    s = s.toLowerCase()
         .replaceAll("[^a-z0-9]", "");  // Keep only alphanumeric
    return checkHelper(s, 0, s.length() - 1);
}

isPalindromeAlphanumeric("A man, a plan, a canal: Panama");
// "amanaplanacanalpanama" → true ✓

isPalindromeAlphanumeric("race a car");
// "raceacar" → false ✗
```

### Inline Character Check (Advanced)

```java
private static boolean checkHelperAlphanumeric(String s, int left, int right) {
    // Skip non-alphanumeric characters
    while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
    }
    while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
    }
    
    // Compare characters (case-insensitive)
    if (Character.toLowerCase(s.charAt(left)) != 
        Character.toLowerCase(s.charAt(right))) {
        return false;
    }
    
    return checkHelperAlphanumeric(s, left + 1, right - 1);
}
```

---

## Common Mistakes & Fixes

### ❌ Mistake 1: No Base Case
```java
// WRONG
private static boolean wrong(String s, int left, int right) {
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    return wrong(s, left + 1, right - 1);  // No base case!
}

// Result: StackOverflowError (left/right cross over) ❌
```

**Fix:**
```java
// RIGHT
private static boolean correct(String s, int left, int right) {
    if (left >= right) return true;  // ✓ Base case
    
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    return correct(s, left + 1, right - 1);
}
```

### ❌ Mistake 2: Wrong Base Case Condition
```java
// WRONG
private static boolean wrong(String s, int left, int right) {
    if (left == right) return true;  // Wrong! Should be >=
    
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    return wrong(s, left + 1, right - 1);
}

// For even-length strings, this might call with left > right
// Result: StringIndexOutOfBoundsException ❌
```

**Fix:**
```java
// RIGHT
private static boolean correct(String s, int left, int right) {
    if (left >= right) return true;  // ✓ Handles both odd/even
    
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    return correct(s, left + 1, right - 1);
}
```

### ❌ Mistake 3: Not Returning False on Mismatch
```java
// WRONG
private static boolean wrong(String s, int left, int right) {
    if (left >= right) return true;
    
    if (s.charAt(left) != s.charAt(right)) {
        // Forgot to return!
    }
    
    return wrong(s, left + 1, right - 1);  // Continues anyway!
}

// Result: Returns true even for non-palindromes ❌
```

**Fix:**
```java
// RIGHT
private static boolean correct(String s, int left, int right) {
    if (left >= right) return true;
    
    if (s.charAt(left) != s.charAt(right)) {
        return false;  // ✓ Return immediately
    }
    
    return correct(s, left + 1, right - 1);
}
```

### ❌ Mistake 4: Off-by-One in Initialization
```java
// WRONG
public static boolean wrong(String s) {
    return checkHelper(s, 0, s.length());  // Should be length-1!
}

// Result: StringIndexOutOfBoundsException ❌
```

**Fix:**
```java
// RIGHT
public static boolean correct(String s) {
    return checkHelper(s, 0, s.length() - 1);  // ✓ Correct
}
```

### ❌ Mistake 5: Modifying String (Creates Copies)
```java
// INEFFICIENT
private static boolean wrong(String s, int left, int right) {
    String trimmed = s.trim();  // Creates new string each call!
    
    if (left >= right) return true;
    
    if (trimmed.charAt(left) != trimmed.charAt(right)) {
        return false;
    }
    
    return wrong(trimmed, left + 1, right - 1);
}

// Result: Extra memory usage and time ❌
```

**Fix:**
```java
// RIGHT
private static boolean correct(String s, int left, int right) {
    if (left >= right) return true;
    
    if (s.charAt(left) != s.charAt(right)) {
        return false;
    }
    
    return correct(s, left + 1, right - 1);
}

// Preprocess string once before calling
public static boolean correctWrapper(String s) {
    s = s.toLowerCase();  // ✓ Do once before recursion
    return correct(s, 0, s.length() - 1);
}
```

---

## Test Cases

### Test 1: Simple Palindromes
```java
System.out.println(isPalindrome("hannah"));      // true ✓
System.out.println(isPalindrome("racecar"));     // true ✓
System.out.println(isPalindrome("a"));           // true ✓
System.out.println(isPalindrome("aba"));         // true ✓
System.out.println(isPalindrome("abba"));        // true ✓
```

### Test 2: Non-Palindromes
```java
System.out.println(isPalindrome("hello"));       // false ✗
System.out.println(isPalindrome("world"));       // false ✗
System.out.println(isPalindrome("abc"));         // false ✗
```

### Test 3: Case Sensitivity
```java
System.out.println(isPalindrome("Racecar"));     // false (case-sensitive)
System.out.println(isPalindromeIgnoreCase("Racecar"));  // true
System.out.println(isPalindrome("aAbBaa"));      // false
System.out.println(isPalindromeIgnoreCase("aAbBaa"));   // true
```

### Test 4: With Spaces/Punctuation
```java
String testStr = "A man, a plan, a canal: Panama";
System.out.println(isPalindrome(testStr));      // false (has spaces/commas)
System.out.println(isPalindromeAlphanumeric(testStr));  // true
```

### Test 5: Edge Cases
```java
System.out.println(isPalindrome(""));           // true (empty)
System.out.println(isPalindrome("a"));          // true (single)
System.out.println(isPalindrome("aa"));         // true (two same)
System.out.println(isPalindrome("ab"));         // false (two different)
```

---

## Key Patterns Learned

### Pattern: Two-Pointer String Recursion
```
Used for:
- Palindrome checking ✓
- String comparison
- Finding matching pairs

Template:
private static boolean twoPointerCheck(String s, int left, int right) {
    if (left >= right) return true;
    
    if (condition_mismatch) {
        return false;
    }
    
    return twoPointerCheck(s, left + 1, right - 1);
}
```

---

## Key Takeaways

✅ **What We Learned:**
1. Two-pointer technique for strings
2. Early return on mismatch
3. Base case handling for odd/even lengths
4. Case-sensitivity and special characters
5. Time O(n), Space O(n) for recursion

✅ **When to Use:**
- Palindrome checking (obviously!)
- Two-pointer string problems
- Validating sequences
- Mirror comparisons

✅ **Alternatives:**
- Iterative: Better (O(1) space)
- Reverse & compare: Simple but wasteful
- Built-in functions: Best for production

✅ **Real-World Applications:**
- Bioinformatics: DNA sequence validation
- Data validation: Input checking
- Cryptography: Pattern recognition
- Text processing: String analysis

---

## Summary

| Aspect | Details |
|--------|---------|
| **Problem** | Check if string is palindrome |
| **Approach** | Two-pointer recursion |
| **Base Case** | left >= right → return true |
| **Check** | s.charAt(left) != s.charAt(right) |
| **Recursive** | checkHelper(s, left+1, right-1) |
| **Time** | O(n) |
| **Space** | O(n) |
| **Difficulty** | ⭐⭐ Intermediate |

---

## 🎉 YOU'VE COMPLETED ALL 6 PROBLEMS!

---

## Quick Reference: All 6 Problems

| # | Problem | Technique | Time | Space | Difficulty |
|---|---------|-----------|------|-------|------------|
| 1 | Print Name N Times | Basic Recursion | O(n) | O(n) | ⭐ Easy |
| 2 | Print 1 to N | Print After Recursion | O(n) | O(n) | ⭐⭐ Medium |
| 3 | Sum of N Numbers | Return Value | O(n) | O(n) | ⭐⭐ Medium |
| 4 | Factorial | Multiplication | O(n) | O(n) | ⭐⭐ Medium |
| 5 | Reverse Array | Two-Pointer | O(n) | O(n) | ⭐⭐⭐ Medium |
| 6 | Palindrome Check | Two-Pointer String | O(n) | O(n) | ⭐⭐ Medium |

---

## Progression Path

```
FOUNDATION:
1. Print Name N Times (basic structure)
    ↓
2. Print 1 to N (print before vs after)
    ↓
3. Sum of N Numbers (return values)
    ↓
ADVANCED:
4. Factorial (multiplicative recursion)
    ↓
5. Reverse Array (two-pointer arrays)
    ↓
6. Palindrome Check (two-pointer strings)
```

---

## Next Steps:

1. ✅ **Understand Each Problem** - Read explanations
2. ✅ **Trace Execution** - Draw call stacks
3. ✅ **Test Cases** - Run provided tests
4. ✅ **Variations** - Try case-insensitive, etc.
5. ✅ **Alternatives** - Implement iterative versions
6. ✅ **Optimize** - Reduce space complexity where possible

---

**🚀 Ready to Master Recursion!** Implement these 6 problems and you'll have solid recursion fundamentals.
