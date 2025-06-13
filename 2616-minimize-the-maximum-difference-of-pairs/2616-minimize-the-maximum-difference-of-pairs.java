class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;

        // Step 1: Sort the array
        sort(nums);

        // Step 2: Binary search on the answer
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFormPairs(nums, p, mid)) {
                result = mid;
                high = mid - 1; // try to minimize further
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;

        while (i < nums.length - 1) {
            if (Math.abs(nums[i] - nums[i + 1]) <= maxDiff) {
                count++;
                i += 2; // skip the next element, as it's used in a pair
            } else {
                i++;
            }
            if (count >= p) return true;
        }

        return count >= p;
    }

    // Simple insertion sort (since you requested no imports)
    private void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }
}

  