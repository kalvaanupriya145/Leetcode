class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        java.util.Arrays.sort(nums); // sort the array first
        long count = 0;

        for (int i = 0; i < n; i++) {
            count += countInRange(nums, i + 1, n - 1, lower - nums[i], upper - nums[i]);
        }

        return count;
    }

    private long countInRange(int[] nums, int left, int right, int low, int high) {
        int l = lowerBound(nums, left, right, low);
        int r = upperBound(nums, left, right, high);
        return r - l;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int left, int right, int target) {
        int ans = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans + 1; // +1 because we want the first greater position
    }
}
