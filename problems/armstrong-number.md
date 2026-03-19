# Armstrong Number

## Problem

Check if a given number `n` is an Armstrong number.

An **Armstrong number** (also called a narcissistic number) is a number that equals the sum of its own digits each raised to the power of the number of digits.

---

## Example

### Input
```
n = 153
```

### Output
```
true
```

### Explanation
```
Number of digits = 3

1³ + 5³ + 3³ = 1 + 125 + 27 = 153

153 == 153 → true
```

### Input
```
n = 123
```

### Output
```
false
```

### Explanation
```
1³ + 2³ + 3³ = 1 + 8 + 27 = 36

36 ≠ 123 → false
```

---

## Logic

1. Find the number of digits `d` in `n`.
2. Extract each digit, raise it to the power `d`, and add to sum.
3. If sum equals the original number, it is an Armstrong number.

---

## Solution

```java
public class ArmstrongNumber {

    public boolean isArmstrong(int n) {
        int original = n;
        int digits = 0;
        int temp = n;

        while (temp > 0) {
            temp /= 10;
            digits++;
        }

        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += (int) Math.pow(digit, digits);
            n /= 10;
        }

        return sum == original;
    }
}
```

---

## Dry Run

```
n = 153
original = 153
digits   = 3
sum      = 0

Iteration 1: digit = 153 % 10 = 3,  sum = 0  + 3³ = 27,  n = 15
Iteration 2: digit = 15  % 10 = 5,  sum = 27 + 5³ = 152, n = 1
Iteration 3: digit = 1   % 10 = 1,  sum = 152 + 1³ = 153, n = 0

n = 0 → loop ends

sum (153) == original (153) → true
```

---

## Complexity

```
Time Complexity  : O(d)  where d = number of digits
Space Complexity : O(1)
```

---

## Well-Known Armstrong Numbers

```
1, 2, 3, 4, 5, 6, 7, 8, 9   (1-digit)
153, 370, 371, 407           (3-digit)
1634, 8208, 9474             (4-digit)
```
