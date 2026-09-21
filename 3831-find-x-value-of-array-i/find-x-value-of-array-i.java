class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];

        for (int a : nums) {
            long[] ndp = new long[k];

            ndp[a % k]++;

            for (int r = 0; r < k; r++) {
                int nr = (int)((r * 1L * (a % k)) % k);
                ndp[nr] += dp[r];
            }

            for (int r = 0; r < k; r++)
                ans[r] += ndp[r];

            dp = ndp;
        }

        return ans;
    }
}