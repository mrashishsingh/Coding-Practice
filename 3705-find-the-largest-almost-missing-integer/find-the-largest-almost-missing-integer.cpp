class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int n = nums.size(), ans = -1;
        for (int x : nums) {
            int c = 0;
            for (int i = 0; i <= n - k; i++) {
                for (int j = i; j < i + k; j++) {
                    if (nums[j] == x) {
                        c++;
                        break;
                    }
                }
            }
            if (c == 1) ans = max(ans, x);
        }
        return ans;
    }
};