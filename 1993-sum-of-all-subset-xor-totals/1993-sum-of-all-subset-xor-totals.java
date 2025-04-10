class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        // Include the current number
        int with = dfs(nums, index + 1, currentXor ^ nums[index]);
        // Exclude the current number
        int without = dfs(nums, index + 1, currentXor);
        return with + without;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 3};
        System.out.println(sol.subsetXORSum(nums));  // Output: 6
    }
}
