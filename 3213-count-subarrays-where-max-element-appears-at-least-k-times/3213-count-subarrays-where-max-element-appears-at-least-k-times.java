class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        long count = 0;
        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max) {
                maxCount++;
            }

            while (maxCount >= k) {
                count += nums.length - right;
                if (nums[left] == max) {
                    maxCount--;
                }
                left++;
            }
        }

        return count;
    }
}
