class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, ans = 0;
        for (int r = 0; r < nums.length; r++) {
            m.put(nums[r], m.getOrDefault(nums[r], 0) + 1);
            while (m.get(nums[r]) > k)
                m.put(nums[l], m.get(nums[l++]) - 1);
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}