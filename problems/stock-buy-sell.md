# Best Time to Buy and Sell Stock (#121 LeetCode)

## Problem

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

You want to maximize your profit by choosing a **single day to buy** one stock and choosing a **different day in the future to sell** that stock.

Return the maximum profit you can achieve. If you cannot achieve any profit, return `0`.

---

## Example

**Input**

prices = [7,1,5,3,6,4]

**Output**

5

---

## Explanation

Buy on day 2 (price = 1)  
Sell on day 5 (price = 6)  
Profit = 6 - 1 = 5

---

## Brute Force Idea

Try every possible buy day `i` and every sell day `j > i`, compute:

profit = prices[j] - prices[i]

Keep the maximum profit.

---

## Optimized Idea (Greedy)

Maintain:

- `minPrice` = minimum price seen so far
- `maxProfit` = maximum profit so far

For each price:

- Update `minPrice` if current price is smaller
- Else compute profit = current price - minPrice and update maxProfit

---

## Time Complexity

- Brute Force: **O(n²)**
- Optimized: **O(n)**

---

## Space Complexity

- Optimized: **O(1)**
