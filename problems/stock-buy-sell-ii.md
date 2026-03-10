# Best Time to Buy and Sell Stock II (#122 LeetCode)

## Problem

You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

On each day, you may decide to buy and/or sell the stock.

You can hold **at most one share** of the stock at any time. However, you can buy it then immediately sell it on the same day.

Return the maximum profit you can achieve.

---

## Example

**Input**

prices = [7,1,5,3,6,4]

**Output**

7

---

## Explanation

We can make profit by taking every increasing step:

- Buy at 1, sell at 5 → profit = 4
- Buy at 3, sell at 6 → profit = 3

Total profit = 4 + 3 = 7

---

## Key Observation

Whenever `prices[i] > prices[i-1]`, we can add the difference to the answer.

Because that difference represents a valid profit from buying yesterday and selling today (or as part of a longer increasing sequence).

---

## Optimized Idea

Loop from day 1 to end:

If `prices[i] > prices[i-1]`  
profit += prices[i] - prices[i-1]

---

## Time Complexity

**O(n)**

---

## Space Complexity

**O(1)**
