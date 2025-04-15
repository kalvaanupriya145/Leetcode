class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map value to index in nums2
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        // Transform nums1 to position array
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = pos[nums1[i]];
        }

        long[] leftSmaller = new long[n];
        long[] rightGreater = new long[n];

        // Fenwick tree to count elements on the left
        FenwickTree leftTree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            leftSmaller[i] = leftTree.query(transformed[i]);
            leftTree.update(transformed[i], 1);
        }

        // Fenwick tree to count elements on the right
        FenwickTree rightTree = new FenwickTree(n);
        for (int i = n - 1; i >= 0; i--) {
            rightGreater[i] = rightTree.query(n - 1) - rightTree.query(transformed[i]);
            rightTree.update(transformed[i], 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            count += leftSmaller[i] * rightGreater[i];
        }

        return count;
    }

    // Binary Indexed Tree / Fenwick Tree
    class FenwickTree {
        private long[] tree;

        FenwickTree(int size) {
            tree = new long[size + 1];
        }

        void update(int index, long value) {
            index++;
            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        long query(int index) {
            index++;
            long result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }
}

    