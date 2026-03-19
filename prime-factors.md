# Prime Factors

## Introduction
In this document, we discuss various methods to find the prime factors of a number.

## Platform Links
- [LeetCode](https://leetcode.com)
- [GeeksforGeeks](https://www.geeksforgeeks.org)
- [HackerRank](https://www.hackerrank.com)

## Distinction Between All and Unique Factors
- **All Factors**: All numbers that divide the given number without leaving a remainder.
- **Unique Factors**: The distinct prime factors (i.e., each prime factor is only counted once).

## Approaches to Find Prime Factors
1. **Trial Division**: Testing for divisibility by prime numbers.
2. **Sieve of Eratosthenes**: Efficient generation of primes to use in factorization.
3. **Pollard's Rho Algorithm**: A probabilistic technique for integer factorization.
4. **Wheel Factorization**: An optimized approach combining various techniques to skip certain numbers.

## Detailed Dry Run Examples
### Example 1: 60
- **All Factors**: 1, 2, 3, 4, 5, 6, 10, 12, 15, 20, 30, 60  
- **Unique Prime Factors**: 2, 3, 5  

### Example 2: 84
- **All Factors**: 1, 2, 3, 4, 6, 7, 12, 14, 21, 28, 42, 84  
- **Unique Prime Factors**: 2, 3, 7  

### Example 3: 45
- **All Factors**: 1, 3, 5, 9, 15, 45  
- **Unique Prime Factors**: 3, 5  

### Example 4: 100
- **All Factors**: 1, 2, 4, 5, 10, 20, 25, 50, 100  
- **Unique Prime Factors**: 2, 5  

### Example 5: 71 (prime number)
- **All Factors**: 1, 71  
- **Unique Prime Factors**: 71  

### Example 6: 12
- **All Factors**: 1, 2, 3, 4, 6, 12  
- **Unique Prime Factors**: 2, 3  
