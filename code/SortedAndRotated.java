class SortedAndRotated {

    // An array is sorted and rotated if there is at most one position where
    // nums[i] > nums[i+1] (treating the array as circular).
    //
    // Time Complexity: O(n) — single pass through the array
    // Space Complexity: O(1) — no extra space used
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
