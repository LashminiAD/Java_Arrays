class LargestElement {

    // Time Complexity: O(n) — single pass through the array
    // Space Complexity: O(1) — no extra space used
    // Assumption: nums is non-empty (returns Integer.MIN_VALUE for an empty array)
    public int largestElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}
