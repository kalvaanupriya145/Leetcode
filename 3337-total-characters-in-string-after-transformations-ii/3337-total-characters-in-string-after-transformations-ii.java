class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[26];

        // Count initial frequency of each character in the input string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Fast exponentiation loop for t transformations
        while (t > 0) {
            if ((t & 1) == 1) {
                freq = applyTransform(freq, nums);
            }
            nums = merge(nums, nums);
            t >>= 1;
        }

        long result = 0;
        for (long count : freq) {
            result = (result + count) % MOD;
        }

        return (int) result;
    }

    // Applies one transformation: each character contributes to the next nums[c] characters
    private long[] applyTransform(long[] freq, List<Integer> nums) {
        long[] newFreq = new long[26];

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            int steps = nums.get(i);
            for (int j = 1; j <= steps; j++) {
                int idx = (i + j) % 26;
                newFreq[idx] = (newFreq[idx] + freq[i]) % MOD;
            }
        }

        return newFreq;
    }

    // Multiplies transformation rules (merges two nums lists)
    private List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new java.util.ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            int total = 0;
            for (int j = 1; j <= a.get(i); j++) {
                int idx = (i + j) % 26;
                total = (total + b.get(idx)) % MOD;
            }
            result.add(total);
        }
        return result;
    }
}
