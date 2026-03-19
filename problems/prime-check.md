# Prime Check

## Problem

Check whether a given integer `n` is a prime number.

A prime number is a number greater than 1 that has no divisors other than 1 and itself.

---

## Example

### Input
```
n = 7
```

### Output
```
true
```

### Input
```
n = 10
```

### Output
```
false
```

---

## Logic

Check divisibility from 2 up to √n.  
If `n` is divisible by any number in that range, it is not prime.

---

## Solution

```java
public class PrimeCheck {

    public boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
```

---

## Dry Run

```
n = 7

i = 2 → i * i = 4 ≤ 7 → 7 % 2 = 1 ≠ 0 → continue
i = 3 → i * i = 9 > 7 → loop ends

No divisor found → return true
```

```
n = 10

i = 2 → i * i = 4 ≤ 10 → 10 % 2 = 0 → return false
```

---

## Complexity

```
Time Complexity  : O(√n)
Space Complexity : O(1)
```

---

## Why Check Only Up To √n?

If `n` has a divisor `d > √n`, then `n / d < √n` is also a divisor.  
So we only need to check up to √n to find all divisors.
