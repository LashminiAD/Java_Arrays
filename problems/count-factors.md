# Count Factors

## Problem

Count the total number of divisors (factors) of a given integer `n`.

---

## Example

### Input
```
n = 6
```

### Output
```
4
```

### Explanation
```
Divisors of 6 = [1, 2, 3, 6]
Count         = 4
```

---

## Logic

Iterate from 1 up to √n.  
For each `i` that divides `n`, increment count by 1.  
If `i ≠ n/i`, increment count by 1 again (to count both divisors).

---

## Solution

```java
public class CountFactors {

    public int countFactors(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }

        return count;
    }
}
```

---

## Dry Run

```
n = 6

i = 1 → 6 % 1 = 0 → count++ (count = 1)
         1 ≠ 6 → count++ (count = 2)

i = 2 → 6 % 2 = 0 → count++ (count = 3)
         2 ≠ 3 → count++ (count = 4)

i = 3 → 3 * 3 = 9 > 6 → loop ends

Result: 4
```

---

## Complexity

```
Time Complexity  : O(√n)
Space Complexity : O(1)
```
