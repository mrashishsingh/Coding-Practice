class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] idx = new int[m];
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, (long) dp[idx[j]] * primes[j]);
            }

            dp[i] = (int) min;

            for (int j = 0; j < m; j++) {
                if ((long) dp[idx[j]] * primes[j] == min) {
                    idx[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}