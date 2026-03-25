class LinearSearch {

    // Returns the index of the first occurrence of target, or -1 if not found.
    //
    // Time Complexity: O(n) — worst case scans the entire array
    // Space Complexity: O(1) — no extra space used
    public int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
