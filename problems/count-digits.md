# Count Digits Problem Statement
Given an integer number, the task is to count the number of digits present in it.

## Approaches
1. **Iterative Approach**: Count digits using a loop until the number becomes zero.
    - Start with count as 0.
    - While the number is greater than 0, increment count and divide the number by 10.

2. **String Conversion**: Convert the number to a string and return the length of the string.
    - Convert the number to string using `String.valueOf(num)` and return `numStr.length()`.

3. **Logarithmic Approach**: Use logarithms to count digits.
    - The number of digits in a number `n` can be counted using `Math.floor(Math.log10(n)) + 1` if `n` is positive.

## Time Complexity
- Iterative Approach: O(log10(n))
- String Conversion: O(1) for conversion, O(d) for length calculation (where d is the number of digits)
- Logarithmic Approach: O(1)

## Dry Run Example
Let's dry run the **Iterative Approach**:
- Input: `12345`
- Steps: 
    - Count = 0
    - 12345 > 0, increment count (count = 1), number = 1234
    - 1234 > 0, increment count (count = 2), number = 123
    - 123 > 0, increment count (count = 3), number = 12
    - 12 > 0, increment count (count = 4), number = 1
    - 1 > 0, increment count (count = 5), number = 0
- Final count of digits is **5**.