# Java Arrays - Session 1

This repository contains a **beginner-friendly introduction to Arrays and Problem Solving using Java**.

This material comes from my **first DSA teaching session**, where students were introduced to **array fundamentals and classic interview problems**.

---

# 📂 Included in this Repository

- 📑 **Session PPT**
- 💻 **Java Example Programs**
- 🧠 **Problem Solving Walkthrough**
- ⚡ **Optimized Solutions**

---

# 📚 Topics Covered

| Topic | Description |
|------|-------------|
| **Arrays Introduction** | Why arrays are needed |
| **Memory Concept** | Contiguous memory allocation |
| **Array Traversal** | Accessing elements |
| **Array Utility Methods** | Arrays.sort(), Arrays.fill() |
| **Linear Search** | Searching elements |
| **Two Sum** | Brute force approach |
| **Best Time to Buy & Sell Stock** | Greedy algorithm |
| **Practice Problem** | Stock Buy & Sell II |

---

# 1️⃣ Why Do We Need Arrays?

Imagine storing numbers using variables:

```java
int a = 1;
int b = 2;
int c = 3;

This works for small data.

But storing 100 numbers would look like:

int a1, a2, a3 ... a100;

This becomes very difficult to manage.

✅ Arrays allow us to store multiple values in a single variable.

2️⃣ Array Definition

An array is a data structure used to store multiple elements of the same data type in a single variable.

Key Characteristics

Same data type elements

Stored in contiguous memory locations

Accessed using index

3️⃣ Array Declaration

int[] arr;

4️⃣ Array Creation

int[] arr = new int[5];

Default values:

0 0 0 0 0

5️⃣ Direct Initialization

int[] arr = {10,20,30,40,50};

6️⃣ Memory Concept (Important)

Example

int[] arr = {10,20,30};

Assume

Base Address = 2048
int = 4 bytes

Memory Layout
arr[0] → 2048
arr[1] → 2052
arr[2] → 2056

⭐ This is called Contiguous Memory Allocation

Because elements are stored continuously in memory.

Access Time Complexity

O(1)

7️⃣ Important Array Methods

Import first

import java.util.Arrays;
Arrays.toString()
System.out.println(Arrays.toString(arr));

Output

[5, 2, 8, 1]
Arrays.sort()
Arrays.sort(arr);

Output

[1,2,5,8]

Arrays.fill()

Arrays.fill(arr, -1);

Result

[-1,-1,-1,-1,-1]

Arrays.copyOf()

int[] arr2 = Arrays.copyOf(arr1, arr1.length);

8️⃣ Traversing an Array

Using for loop

for(int i=0;i<arr.length;i++){
    System.out.println(arr[i]);
}

Enhanced for loop //For-each Loop

for(int a : arr){
    System.out.println(a);
}

Time Complexity

O(n)

9️⃣ Linear Search

Example

arr = [3,1,5,1,2]

target = 5

for(int i=0;i<arr.length;i++){
    if(arr[i] == target){
        return i;
    }
}

Time Complexity

O(n)

Space Complexity

O(1)

🔟 Problem 1 — Two Sum (#1)

Brute Force Solution

Time Complexity: O(n²)

⚡ Optimized Two Sum using HashMap

Time Complexity improves to O(n)

1️⃣1️⃣ Best Time to Buy and Sell Stock (#121)

Optimized Greedy Algorithm

🧠 Practice Problem

Best Time to Buy and Sell Stock II (#122)

Students were asked to solve this problem independently first.

Array vs ArrayList

    Array	                         ArrayList
  Fixed Size	                    Dynamic Size
  Faster	                        Slightly Slower
  Cannot add/remove elements    	Can add/remove elements

Example

ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);

🎯 Conclusion

In this session students learned:

✔ Array fundamentals
✔ Memory concepts
✔ Important array methods
✔ Searching and traversal
✔ Real interview problems

⭐ Practice problems are the key to mastering Data Structures and Algorithms.
