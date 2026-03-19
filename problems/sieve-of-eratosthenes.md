# Sieve of Eratosthenes

## Problem

Find all prime numbers less than or equal to `n`.

---

## Example

### Input
```
n = 10
```

### Output
```
[2, 3, 5, 7]
```

---

## Logic

1. Create a boolean array `isPrime[0..n]`, initialized to `true`.
2. Start from `i = 2`. For each prime `i`, mark all multiples of `i` (starting from `i*i`) as `false`.
3. Continue until `i * i > n`.
4. Collect all indices still marked `true` — those are primes.

---

## Solution

```java
import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {

    public int[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

---

## Dry Run

```
n = 10

Initial isPrime: [F, F, T, T, T, T, T, T, T, T, T]
                  0   1  2  3  4  5  6  7  8  9  10

i = 2 → isPrime[2] = true → mark multiples starting from 4:
         isPrime[4] = false
         isPrime[6] = false
         isPrime[8] = false
         isPrime[10] = false

         isPrime: [F, F, T, T, F, T, F, T, F, T, F]

i = 3 → isPrime[3] = true → mark multiples starting from 9:
         isPrime[9] = false

         isPrime: [F, F, T, T, F, T, F, T, F, F, F]

i = 4 → 4 * 4 = 16 > 10 → loop ends

Collect all i where isPrime[i] = true:
2, 3, 5, 7

Result: [2, 3, 5, 7]
```

---

## Complexity

```
Time Complexity  : O(n log log n)
Space Complexity : O(n)
```

---

## Why Start Marking From i*i?

All smaller multiples of `i` (like `2*i`, `3*i`, ...) have already been marked  
by smaller primes in previous iterations.  
Starting from `i*i` avoids redundant work.
