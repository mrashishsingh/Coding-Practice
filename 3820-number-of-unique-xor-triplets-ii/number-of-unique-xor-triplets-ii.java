class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[][] dp = new boolean[4][2048];
        dp[0][0] = true;
        for (int v : nums) {
            boolean[][] nd = new boolean[4][2048];
            for (int i = 0; i < 4; i++) nd[i] = dp[i].clone();
            for (int k = 0; k < 4; k++)
                for (int x = 0; x < 2048; x++)
                    if (dp[k][x]) {
                        if (k < 3) nd[k + 1][x ^ v] = true;
                        if (k < 2) nd[k + 2][x] = true;
                        if (k < 1) nd[k + 3][x ^ v] = true;
                    }
            dp = nd;
        }
        int ans = 0;
        for (boolean b : dp[3]) if (b) ans++;
        return ans;
    }
}