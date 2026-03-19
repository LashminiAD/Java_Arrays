# GCD (Greatest Common Divisor)

## Problem

Find the GCD (Greatest Common Divisor) of two integers `a` and `b` using the Euclidean Algorithm.

---

## Example

### Input
```
a = 12
b = 18
```

### Output
```
6
```

### Explanation
```
Divisors of 12 = [1, 2, 3, 4, 6, 12]
Divisors of 18 = [1, 2, 3, 6, 9, 18]

Common Divisors = [1, 2, 3, 6]
GCD             = 6
```

---

## Logic

Use the Euclidean Algorithm:  
Replace `a` with `b` and `b` with `a % b`.  
Repeat until `b` becomes 0.  
At that point, `a` holds the GCD.

---

## Solution

```java
public class GCD {

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
```

---

## Dry Run

```
a = 12, b = 18

Step 1: temp = 18,  b = 12 % 18 = 12,  a = 18  → a = 18, b = 12
Step 2: temp = 12,  b = 18 % 12 = 6,   a = 12  → a = 12, b = 6
Step 3: temp = 6,   b = 12 % 6  = 0,   a = 6   → a = 6,  b = 0

b = 0 → loop ends

Result: 6
```

---

## Complexity

```
Time Complexity  : O(log(min(a, b)))
Space Complexity : O(1)
```

---

## Key Insight

The Euclidean Algorithm is based on the property:

```
GCD(a, b) = GCD(b, a % b)
```

This is because any common divisor of `a` and `b` also divides `a % b`.
