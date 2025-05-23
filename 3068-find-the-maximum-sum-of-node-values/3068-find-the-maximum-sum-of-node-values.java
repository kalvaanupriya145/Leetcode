class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long total = 0;
        int countBetter = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            total += Math.max(num, xorVal);

            // Track how many are better with XOR
            if (xorVal > num) countBetter++;
            
            // Track the smallest absolute difference between num and xorVal
            minDiff = Math.min(minDiff, Math.abs(num - xorVal));
        }

        // If countBetter is even, all XORs can be paired => max sum
        if (countBetter % 2 == 0) {
            return total;
        } else {
            // One unpaired XOR will reduce sum => remove its effect
            return total - minDiff;
        }
    }
}

