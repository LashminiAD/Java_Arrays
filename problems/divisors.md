# Divisors of a Number

## Problem

Find all divisors of a given integer `n` and return them in sorted order.

---

## Example

### Input
```
n = 6
```

### Output
```
[1, 2, 3, 6]
```

---

## Logic

Iterate from 1 up to √n.  
For each `i` that divides `n`, both `i` and `n/i` are divisors (add both unless equal).  
Sort the result before returning.

---

## Solution

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Divisors {

    public int[] divisors(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                result.add(i);
                if (i != n / i) {
                    result.add(n / i);
                }
            }
        }

        Collections.sort(result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

## Dry Run

```
n = 6

i = 1 → 1 * 1 = 1 ≤ 6 → 6 % 1 = 0 → add 1, add 6/1 = 6 → [1, 6]
i = 2 → 2 * 2 = 4 ≤ 6 → 6 % 2 = 0 → add 2, add 6/2 = 3 → [1, 6, 2, 3]
i = 3 → 3 * 3 = 9 > 6 → loop ends

After sort: [1, 2, 3, 6]

Result: [1, 2, 3, 6]
```

---

## Complexity

```
Time Complexity  : O(√n)
Space Complexity : O(d)  where d = number of divisors
```
