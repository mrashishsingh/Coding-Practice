class Solution {
public:
    int maximumLengthSubstring(string s) {
        int a[26] = {0};
        int l = 0, ans = 0;

        for (int r = 0; r < s.size(); r++) {
            a[s[r] - 'a']++;

            while (a[s[r] - 'a'] > 2) {
                a[s[l] - 'a']--;
                l++;
            }

            ans = max(ans, r - l + 1);
        }

        return ans;
    }
};