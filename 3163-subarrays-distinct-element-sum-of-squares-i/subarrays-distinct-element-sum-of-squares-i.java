class Solution {
    public int sumCounts(java.util.List<Integer> nums) {
        int n = nums.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            java.util.HashSet<Integer> s = new java.util.HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                ans += s.size() * s.size();
            }
        }
        return ans;
    }
}