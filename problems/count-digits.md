# Count Digits

## Problem

Count the number of digits in a given integer `n`.

---

## Example

### Input
```
n = 12345
```

### Output
```
5
```

---

## Logic

Divide `n` by 10 repeatedly and count each iteration until `n` becomes 0.

---

## Solution

```java
public class CountDigits {

    public int countDigits(int n) {
        if (n == 0) return 1;

        int count = 0;

        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }
}
```

---

## Dry Run

```
n = 12345

Iteration 1: n = 12345 / 10 = 1234,  count = 1
Iteration 2: n = 1234  / 10 = 123,   count = 2
Iteration 3: n = 123   / 10 = 12,    count = 3
Iteration 4: n = 12    / 10 = 1,     count = 4
Iteration 5: n = 1     / 10 = 0,     count = 5

n = 0 → loop ends

Result: 5
```

---

## Complexity

```
Time Complexity  : O(d)  where d = number of digits
Space Complexity : O(1)
```
