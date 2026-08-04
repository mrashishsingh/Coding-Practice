class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();

        int mn = nums[0], mx = nums[0];

        for (int x : nums) {
            s.add(x);
            mn = Math.min(mn, x);
            mx = Math.max(mx, x);
        }

        for (int i = mn; i <= mx; i++) {
            if (!s.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}