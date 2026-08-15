class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int a = s.charAt(i - 1) - '0';

            if (a >= 1 && a <= 9)
                dp[i] += dp[i - 1];

            if (i >= 2) {
                int b = (s.charAt(i - 2) - '0') * 10 + a;

                if (b >= 10 && b <= 26)
                    dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}