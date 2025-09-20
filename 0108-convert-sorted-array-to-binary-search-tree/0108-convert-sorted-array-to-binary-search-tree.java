class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperfunction(nums, 0, nums.length );        
    }

    TreeNode helperfunction(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helperfunction(nums, left, mid );
        node.right = helperfunction(nums, mid + 1, right);
        return node;
    }    
}
