class LeftRotateByOne {

    // Rotate the array left by 1 position in-place.
    // Save the first element, shift all others one step left, place saved element at the end.
    //
    // Time Complexity: O(n) — single pass through the array
    // Space Complexity: O(1) — no extra space used
    public void rotateLeft(int[] nums) {
        if (nums.length == 0) return;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = first;
    }
}
