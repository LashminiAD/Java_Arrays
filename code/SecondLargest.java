class SecondLargest {

    public int getSecondLargest(int[] arr) {

        int largestVal = Integer.MIN_VALUE;
        int secondLargeVal = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largestVal) {
                secondLargeVal = largestVal;
                largestVal = arr[i];
            }

            else if (arr[i] < largestVal && arr[i] > secondLargeVal) {
                secondLargeVal = arr[i];
            }
        }

        if (secondLargeVal == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargeVal;
    }
}
