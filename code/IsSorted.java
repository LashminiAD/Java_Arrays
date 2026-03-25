class IsSorted {

    // Time Complexity: O(n) — single pass through the array
    // Space Complexity: O(1) — no extra space used
    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
