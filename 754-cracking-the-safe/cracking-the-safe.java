class Solution {
    Set<String> vis = new HashSet<>();
    StringBuilder ans = new StringBuilder();

    public String crackSafe(int n, int k) {
        String s = "0".repeat(n - 1);
        dfs(s, k);
        ans.append(s);
        return ans.toString();
    }

    void dfs(String s, int k) {
        for (int i = 0; i < k; i++) {
            String t = s + i;
            if (vis.add(t)) {
                dfs(t.substring(1), k);
                ans.append(i);
            }
        }
    }
}