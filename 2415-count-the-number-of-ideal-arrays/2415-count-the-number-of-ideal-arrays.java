class Solution {
    static final int MOD = 1_000_000_007;

    public int idealArrays(int n, int maxValue) {
        int[][] dp = new int[15][maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }
        
        for (int len = 2; len <= 14; len++) {  // max log(maxValue) ~ 14
            for (int i = 1; i <= maxValue; i++) {
                for (int j = 2 * i; j <= maxValue; j += i) {
                    dp[len][j] = (dp[len][j] + dp[len - 1][i]) % MOD;
                }
            }
        }
        
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = pow(fact[n], MOD - 2);
        for (int i = n - 1; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        long ans = 0;
        for (int len = 1; len <= 14; len++) {
            for (int val = 1; val <= maxValue; val++) {
                if (dp[len][val] > 0 && n >= len) {
                    long ways = comb(n - 1, len - 1, fact, invFact);
                    ans = (ans + dp[len][val] * ways) % MOD;
                }
            }
        }
        return (int) ans;
    }

    private long comb(int n, int k, long[] fact, long[] invFact) {
        if (n < k || k < 0) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
