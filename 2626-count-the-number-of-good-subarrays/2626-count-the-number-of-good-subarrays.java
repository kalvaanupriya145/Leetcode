class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0; // Total number of good subarrays
        long pairs = 0; // Number of valid pairs in current window
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            int currFreq = freq.getOrDefault(curr, 0);
            
            // Add new pairs formed with current element
            pairs += currFreq;
            freq.put(curr, currFreq + 1);

            // Shrink window from the left until pairs < k
            while (pairs >= k) {
                count += nums.length - right; // All subarrays from [left, right] to [left, end]
                int leftVal = nums[left];
                int leftFreq = freq.get(leftVal);
                pairs -= (leftFreq - 1);
                freq.put(leftVal, leftFreq - 1);
                left++;
            }
        }

        return count;
    }
}

    