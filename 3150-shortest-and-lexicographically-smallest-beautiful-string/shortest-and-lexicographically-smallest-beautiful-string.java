class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int l = 0, c = 0, len = Integer.MAX_VALUE;
        String ans = "";

        for (int r = 0; r < n; r++) {
            if (s.charAt(r) == '1') c++;

            while (c > k) {
                if (s.charAt(l) == '1') c--;
                l++;
            }

            if (c == k) {
                while (l <= r && s.charAt(l) == '0') l++;

                int cur = r - l + 1;

                if (cur < len) {
                    len = cur;
                    ans = s.substring(l, r + 1);
                } else if (cur == len) {
                    String t = s.substring(l, r + 1);
                    if (t.compareTo(ans) < 0) ans = t;
                }
            }
        }

        return ans;
    }
}