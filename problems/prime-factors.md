# Prime Factors (Unique)

## Problem

Find all unique prime factors of a given integer `n`.

---

## Example

### Input
```
n = 60
```

### Output
```
[2, 3, 5]
```

### Explanation
```
60 = 2 × 2 × 3 × 5

Unique prime factors = [2, 3, 5]
```

---

## Logic

Iterate `i` from 2 up to √n.  
If `i` divides `n`, add `i` as a prime factor, then divide `n` by `i` completely.  
If `n > 1` after the loop, `n` itself is a prime factor.

---

## Solution

```java
import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public int[] primeFactors(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            result.add(n);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

## Dry Run

```
n = 60

i = 2 → 60 % 2 = 0 → add 2
           divide: 60 → 30 → 15  (divided out all 2s)
           n = 15

i = 3 → 3 * 3 = 9 ≤ 15 → 15 % 3 = 0 → add 3
           divide: 15 → 5  (divided out all 3s)
           n = 5

i = 4 → 4 * 4 = 16 > 5 → loop ends

n = 5 > 1 → add 5

Result: [2, 3, 5]
```

---

## Complexity

```
Time Complexity  : O(√n)
Space Complexity : O(k)  where k = number of unique prime factors
```
