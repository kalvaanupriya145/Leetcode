class Solution {
    public int possibleStringCount(String word, int k) {
        final int MOD = 1_000_000_007;
        int n = word.length();

        // Step 1: Group consecutive identical characters
        List<Integer> groups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                i++;
                count++;
            }
            groups.add(count);
        }

        int maxLen = n;
        int[] dp = new int[maxLen + 1];
        dp[0] = 1;

        // Step 2: DP with sliding window optimization
        for (int group : groups) {
            int[] newDp = new int[maxLen + 1];
            long windowSum = 0;

            for (int len = 1; len <= maxLen; len++) {
                windowSum = (windowSum + dp[len - 1]) % MOD;
                if (len - group - 1 >= 0) {
                    windowSum = (windowSum - dp[len - group - 1] + MOD) % MOD;
                }
                newDp[len] = (int) windowSum;
            }

            dp = newDp;
        }

        // Step 3: Sum results for lengths >= k
        int result = 0;
        for (int len = k; len <= maxLen; len++) {
            result = (result + dp[len]) % MOD;
        }

        return result;
    }
}
