class Solution {
    // Helper class to store both the node and its depth
    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        // If both subtrees have the same depth, root is the LCA
        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        }

        // Return the subtree with the greater depth
        return (left.depth > right.depth) ? new Pair(left.node, left.depth + 1) 
                                          : new Pair(right.node, right.depth + 1);
    }
}
