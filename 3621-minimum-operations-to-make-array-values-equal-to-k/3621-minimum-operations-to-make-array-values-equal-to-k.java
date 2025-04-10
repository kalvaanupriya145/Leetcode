class Solution {
    public int minOperations(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        Set<Integer> greaterThanK = new HashSet<>();
        for (int num : nums) {
            if (num < k) return -1; // can't increase any value to k
            if (num > k) greaterThanK.add(num);
        }

        if (greaterThanK.isEmpty()) {
            // All elements are already k
            for (int num : nums) {
                if (num != k) return -1;
            }
            return 0;
        }

        List<Integer> descending = new ArrayList<>(greaterThanK);
        Collections.sort(descending, Collections.reverseOrder());

        int operations = 0;
        int currentLimit = Integer.MAX_VALUE;

        for (int h : descending) {
            if (h < currentLimit) {
                currentLimit = h;
                operations++;
            }
        }

        return operations;
    }
}

    