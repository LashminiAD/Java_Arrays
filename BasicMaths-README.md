# Basic Maths (DSA)

A collection of fundamental maths problems frequently asked in coding interviews (Easy → Medium).

---

## 🟢 Easy

### 1. Count Digits
**Problem:** Count number of digits in a number  
**File:** [code/CountDigits.java](code/CountDigits.java) | [problems/count-digits.md](problems/count-digits.md)

```
Input:  n = 12345
Output: 5
```
**Logic:** Divide by 10 repeatedly, count iterations.  
**Time:** O(d) | **Space:** O(1)

---

### 2. Prime Check
**Problem:** Check if a number is prime  
**File:** [code/PrimeCheck.java](code/PrimeCheck.java) | [problems/prime-check.md](problems/prime-check.md)

```
Input:  n = 7
Output: true
```
**Logic:** Check divisibility from 2 up to √n.  
**Time:** O(√n) | **Space:** O(1)

---

### 3. Divisors of a Number
**Problem:** Find all divisors of n  
**File:** [code/Divisors.java](code/Divisors.java) | [problems/divisors.md](problems/divisors.md)

```
Input:  n = 6
Output: [1, 2, 3, 6]
```
**Logic:** Iterate up to √n; for each divisor `i`, add both `i` and `n/i`.  
**Time:** O(√n) | **Space:** O(d)

---

### 4. Count Factors
**Problem:** Count total number of divisors  
**File:** [code/CountFactors.java](code/CountFactors.java) | [problems/count-factors.md](problems/count-factors.md)

```
Input:  n = 6
Output: 4
```
**Logic:** Same as divisors, but count instead of store.  
**Time:** O(√n) | **Space:** O(1)

---

### 5. GCD (Euclidean Algorithm)
**Problem:** Find GCD of two numbers  
**File:** [code/GCD.java](code/GCD.java) | [problems/gcd.md](problems/gcd.md)

```
Input:  a = 12, b = 18
Output: 6
```
**Logic:** Replace `a` with `b` and `b` with `a % b` until `b` becomes 0.  
**Time:** O(log(min(a,b))) | **Space:** O(1)

---

## 🟡 Medium

### 6. Prime Factors (Unique)
**Problem:** Find unique prime factors of n  
**File:** [code/PrimeFactors.java](code/PrimeFactors.java) | [problems/prime-factors.md](problems/prime-factors.md)

```
Input:  n = 60
Output: [2, 3, 5]
```
**Logic:** Divide n by each factor completely, skip duplicates automatically.  
**Time:** O(√n) | **Space:** O(k)

---

### 7. Armstrong Number
**Problem:** Check if number is an Armstrong number  
**File:** [code/ArmstrongNumber.java](code/ArmstrongNumber.java) | [problems/armstrong-number.md](problems/armstrong-number.md)

```
Input:  n = 153
Output: true
```
**Logic:** Sum of digits raised to power of digit count equals original number.  
**Time:** O(d) | **Space:** O(1)

---

### 8. Sieve of Eratosthenes
**Problem:** Find all primes ≤ n  
**File:** [code/SieveOfEratosthenes.java](code/SieveOfEratosthenes.java) | [problems/sieve-of-eratosthenes.md](problems/sieve-of-eratosthenes.md)

```
Input:  n = 10
Output: [2, 3, 5, 7]
```
**Logic:** Mark multiples of each prime as non-prime starting from `i*i`.  
**Time:** O(n log log n) | **Space:** O(n)

---

## 💡 Tips and Optimization Notes

### √n Trick
When checking divisibility, you only need to iterate up to √n.  
If a number `d` divides `n`, then `n/d` is also a divisor — and one of them is always ≤ √n.

```
Instead of:  for (int i = 1; i <= n; i++)       → O(n)
Use:         for (int i = 1; i * i <= n; i++)    → O(√n)
```

### Euclidean GCD
The Euclidean Algorithm is much faster than checking all common divisors:

```
GCD(a, b) = GCD(b, a % b)
```

This runs in O(log(min(a, b))) time.

### Sieve vs Repeated Prime Check
- Checking each number individually: O(n √n)
- Sieve of Eratosthenes: O(n log log n)

Use the Sieve when you need **multiple prime queries** in a range.

### Start Marking From i*i in Sieve
When marking multiples of prime `i`, start from `i*i` instead of `2*i`.  
All smaller multiples have already been marked by earlier primes.

---

## 📚 Summary Table

| # | Problem             | Level  | Time Complexity    | Space Complexity |
|---|---------------------|--------|--------------------|-----------------|
| 1 | Count Digits        | Easy   | O(d)               | O(1)            |
| 2 | Prime Check         | Easy   | O(√n)              | O(1)            |
| 3 | Divisors            | Easy   | O(√n)              | O(d)            |
| 4 | Count Factors       | Easy   | O(√n)              | O(1)            |
| 5 | GCD                 | Easy   | O(log(min(a,b)))   | O(1)            |
| 6 | Prime Factors       | Medium | O(√n)              | O(k)            |
| 7 | Armstrong Number    | Medium | O(d)               | O(1)            |
| 8 | Sieve of Eratosthenes | Medium | O(n log log n)   | O(n)            |

---

⭐ **Practice these fundamentals — they are the building blocks of more advanced DSA problems.**
