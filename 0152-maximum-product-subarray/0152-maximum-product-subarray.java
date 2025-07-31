class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // Initialize all with the first element
        int mxp = nums[0];
        int mnp = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            // If the current number is negative, swap max and min
            if (nums[i] < 0) {
                int temp = mxp;
                mxp = mnp;
                mnp = temp;
            }

            mxp = Math.max(nums[i], nums[i] * mxp);
            mnp = Math.min(nums[i], nums[i] * mnp);
            res = Math.max(res, mxp);
        }

        return res;
    }
}
