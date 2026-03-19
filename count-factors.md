# Count Factors

## Approaches
1. **Brute Force Approach**: Iterate through all integers up to the given number and count how many of them divide the number without a remainder.
   - **Time Complexity**: O(n)
   - **Space Complexity**: O(1)

2. **Optimized Approach**: Iterate only up to the square root of the number. For every integer `i` that divides the number, there exists another integer `n/i`. Count both.
   - **Time Complexity**: O(√n)
   - **Space Complexity**: O(1)

## Complexity Analysis
- The brute force approach is simple but inefficient for large numbers, while the optimized approach drastically reduces computation time for large inputs.

## Examples
1. **Example 1**: Count factors of 12
   - Factors: 1, 2, 3, 4, 6, 12
   - Count: 6

2. **Example 2**: Count factors of 28
   - Factors: 1, 2, 4, 7, 14, 28
   - Count: 6

3. **Example 3**: Count factors of 15
   - Factors: 1, 3, 5, 15
   - Count: 4

4. **Example 4**: Count factors of 18
   - Factors: 1, 2, 3, 6, 9, 18
   - Count: 6

## Conclusion
The optimized approach is preferred for larger inputs due to its lower time complexity.