class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minPos = -1, maxPos = -1, leftBound = -1;
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            int validBound = Math.min(minPos, maxPos);
            if (validBound > leftBound) {
                count += validBound - leftBound;
            }
        }
        return count;
    }
}

    