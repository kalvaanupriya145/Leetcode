class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        // Step 1: Build initial coverage
        int[] diff = new int[n + 1];
        for (int[] query : queries) {
            diff[query[0]] += 1;
            if (query[1] + 1 < n) {
                diff[query[1] + 1] -= 1;
            }
        }

        int[] cover = new int[n];
        cover[0] = diff[0];
        for (int i = 1; i < n; i++) {
            cover[i] = cover[i - 1] + diff[i];
        }

        // Step 2: If even total coverage can't handle nums, return -1
        for (int i = 0; i < n; i++) {
            if (cover[i] < nums[i]) return -1;
        }

        // Step 3: Try to remove each query one by one (greedy)
        int removed = 0;

        for (int i = 0; i < q; i++) {
            // Remove current query from a temp coverage array
            int[] temp = cover.clone();
            int l = queries[i][0];
            int r = queries[i][1];

            for (int j = l; j <= r; j++) {
                temp[j]--;
            }

            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (temp[j] < nums[j]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                cover = temp; // finalize the removal
                removed++;
            }
        }

        return removed;
    }
}
