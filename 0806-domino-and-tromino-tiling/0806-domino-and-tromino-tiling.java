class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;

        long[] dp = new long[n + 1];
        dp[0] = 1; // base case: 1 way to tile a 2x0 board (do nothing)
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        long sum = dp[0] + dp[1]; // sum of dp[0] + dp[1]

        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * sum % MOD + dp[i - 1] + dp[i - 2]) % MOD;
            sum = (sum + dp[i - 2]) % MOD;
        }

        return (int) dp[n];
    }
}

    