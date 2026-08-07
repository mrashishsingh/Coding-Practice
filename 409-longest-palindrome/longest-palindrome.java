class Solution {
    public int longestPalindrome(String s) {
        int[] a = new int[128];
        for (char c : s.toCharArray()) a[c]++;
        int ans = 0;
        boolean f = false;
        for (int x : a) {
            ans += (x / 2) * 2;
            if ((x & 1) == 1) f = true;
        }
        return f ? ans + 1 : ans;
    }
}