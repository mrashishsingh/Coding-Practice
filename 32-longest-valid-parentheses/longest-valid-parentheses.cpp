class Solution {
public:
    int longestValidParentheses(string s) {
        int n = s.size();
        int l = 0;
        int r = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(')
                l++;
            else
                r++;
            if (r == l)
                res = max(res, 2 * r);
            if (r > l) {
                l = 0, r = 0;
            }
        }
        l = 0, r = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '(')
                l++;
            else
                r++;
            if (r == l)
                res = max(res, 2 * r);
            if (l > r) {
                r = 0, l = 0;
            }
        }
        return res;
    }
};