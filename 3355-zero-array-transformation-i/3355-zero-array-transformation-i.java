class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] freq = new int[n + 1]; // difference array to track coverage

        // Apply the range updates for each query
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            freq[l] += 1;
            if (r + 1 < n) {
                freq[r + 1] -= 1;
            }
        }

        // Build the prefix sum to get how many times each index is affected
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }

        // Check if every index in nums can be reduced to 0
        for (int i = 0; i < n; i++) {
            if (freq[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}
