class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalCount = 0;
        int n = nums.length;

        // Step 1: Count the number of distinct elements in the whole array
        boolean[] seen = new boolean[2001];
        int totalDistinct = 0;
        for (int num : nums) {
            if (!seen[num]) {
                seen[num] = true;
                totalDistinct++;
            }
        }

        // Step 2: Use sliding window to count complete subarrays
        for (int i = 0; i < n; i++) {
            boolean[] localSeen = new boolean[2001];
            int localDistinct = 0;
            for (int j = i; j < n; j++) {
                if (!localSeen[nums[j]]) {
                    localSeen[nums[j]] = true;
                    localDistinct++;
                }
                if (localDistinct == totalDistinct) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}
