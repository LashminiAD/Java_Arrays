# Java Arrays

## 1️⃣ Why Do We Need Arrays?

Imagine storing numbers using variables:

```java
int a = 1;
int b = 2;
int c = 3;
```

This works for small data.

But storing **100 numbers** would look like:

```java
int a1, a2, a3 ... a100;
```

This becomes very difficult to manage.

✅ **Arrays allow us to store multiple values in a single variable.**

---

## 2️⃣ Array Definition

An **array** is a data structure used to store multiple elements of the **same data type in a single variable**.

### Key Characteristics

* Same data type elements
* Stored in **contiguous memory locations**
* Accessed using **index**

---

## 3️⃣ Array Declaration

```java
int[] arr;
```

---

## 4️⃣ Array Creation

```java
int[] arr = new int[5];
```

### Default values

```
0 0 0 0 0
```

---

## 5️⃣ Direct Initialization

```java
int[] arr = {10,20,30,40,50};
```

---

## 6️⃣ Memory Concept (Important)

Example

```java
int[] arr = {10,20,30};
```

Assume

```
Base Address = 2048
int = 4 bytes
```

### Memory Layout

```
arr[0] → 2048
arr[1] → 2052
arr[2] → 2056
```

⭐ This is called **Contiguous Memory Allocation**

Because elements are stored **continuously in memory**.

### Access Time Complexity

```
O(1)
```

---

## 7️⃣ Important Array Methods

Import first

```java
import java.util.Arrays;
```

### Arrays.toString()

```java
System.out.println(Arrays.toString(arr));
```

Output

```
[5, 2, 8, 1]
```

---

### Arrays.sort()

```java
Arrays.sort(arr);
```

Output

```
[1,2,5,8]
```

---

### Arrays.fill()

```java
Arrays.fill(arr, -1);
```

Result

```
[-1,-1,-1,-1,-1]
```

---

### Arrays.copyOf()

```java
int[] arr2 = Arrays.copyOf(arr1, arr1.length);
```

---

## 8️⃣ Traversing an Array

### Using for loop

```java
for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}
```

### Enhanced for loop (For-each Loop)

```java
for(int a : arr){
    System.out.println(a);
}
```

### Time Complexity

```
O(n)
```

---

## 9️⃣ Linear Search

Example

```
arr = [3,1,5,1,2]
target = 5
```

```java
for(int i=0;i<arr.length;i++){
    if(arr[i] == target){
        return i;
    }
}
```

### Time Complexity

```
O(n)
```

### Space Complexity

```
O(1)
```

---

## 🔟 Problem 1 — Two Sum (#1)

Brute Force Solution

Time Complexity: **O(n²)**

⚡ Optimized Two Sum using **HashMap**

Time Complexity improves to **O(n)**

---

## 1️⃣1️⃣ Best Time to Buy and Sell Stock (#121)

Optimized **Greedy Algorithm**

---

## 🧠 Practice Problem

**Best Time to Buy and Sell Stock II (#122)**

Students were asked to **solve this problem independently first.**

---

## Array vs ArrayList

| Array                      | ArrayList               |
| -------------------------- | ----------------------- |
| Fixed Size                 | Dynamic Size            |
| Faster                     | Slightly Slower         |
| Cannot add/remove elements | Can add/remove elements |

Example

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
```

---

## 🔹 Basic Array Problems (Must Know Before Easy)

| # | Problem | Platform | Solution |
|---|---------|----------|----------|
| 1 | Largest Element in Array | [GFG](https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1) | [LargestElement.java](code/LargestElement.java) |
| 2 | Check if Array is Sorted | [GFG](https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1) | [IsSorted.java](code/IsSorted.java) |
| 3 | Check if Array is Sorted & Rotated | [LeetCode #1752](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/) | [SortedAndRotated.java](code/SortedAndRotated.java) |
| 4 | Second Largest Element | [GFG](https://www.geeksforgeeks.org/problems/second-largest3735/1) | [SecondLargest.java](code/SecondLargest.java) |
| 5 | Linear Search | [GFG](https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1) | [LinearSearch.java](code/LinearSearch.java) |
| 6 | Left Rotate Array by One | [GFG](https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1) | [LeftRotateByOne.java](code/LeftRotateByOne.java) |
| 7 | Rotate Array by K Steps | [LeetCode #189](https://leetcode.com/problems/rotate-array/) | [RotateArrayK.java](code/RotateArrayK.java) |

### Problem Descriptions

1. **Largest Element** — Traverse the array once, tracking the running maximum. **O(n) time, O(1) space.**

2. **Check if Sorted** — Return `false` as soon as any element is smaller than its predecessor. **O(n) time, O(1) space.**

3. **Check if Sorted & Rotated** — Count positions where `nums[i] > nums[(i+1) % n]`. A sorted-rotated array has at most one such "break point". **O(n) time, O(1) space.**

4. **Second Largest** — Single pass maintaining `largest` and `secondLargest` variables; return `-1` if no distinct second largest exists. **O(n) time, O(1) space.**

5. **Linear Search** — Scan left to right and return the index of the first match, or `-1` if not found. **O(n) time, O(1) space.**

6. **Left Rotate by One** — Save `nums[0]`, shift every element one position left, place the saved value at the last index. **O(n) time, O(1) space.**

7. **Rotate Array by K (Reversal Algorithm)** — Reverse the full array, then reverse the first `k` elements, then reverse the remaining `n-k` elements. **O(n) time, O(1) space.**

---

## 🎯 Conclusion

In this session students learned:

✔ **Array fundamentals**
✔ **Memory concepts**
✔ **Important array methods**
✔ **Searching and traversal**
✔ **Real interview problems**

⭐ **Practice problems are the key to mastering Data Structures and Algorithms.**
