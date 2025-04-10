class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        long maxValue = 0;
        int prefixMax = nums[0]; // Track max nums[i] before j

        // Monotonic decreasing stack to maintain max suffix values
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }

        // Iterate through j (middle element)
        for (int j = 1; j < n - 1; j++) {
            if (prefixMax > nums[j]) { // Ensure a valid (i, j, k)
                maxValue = Math.max(maxValue, (long) (prefixMax - nums[j]) * suffixMax[j + 1]);
            }
            prefixMax = Math.max(prefixMax, nums[j]); // Update prefix max
        }

        return maxValue;
    
    }

}