class Solution {
    private static final int MOD = 1_000_000_007;

    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[32];
        for (int x : nums) {
            for (int s = 0; s < 32; s++) {
                if (((x >> s) & 1) != 0) {
                    bits[s]++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < k; i++) {
            long num = 0;
            for (int s = 31; s >= 0; s--) {
                if (bits[s] > 0) {
                    num |= (1L << s);
                    bits[s]--;
                }
            }
            if (num == 0) break;
            ans = (ans + (num * num) % MOD) % MOD;
        }
        return (int) ans;
    }
}