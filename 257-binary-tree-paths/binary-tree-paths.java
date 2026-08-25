class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    void dfs(TreeNode n, String s, List<String> ans) {
        if (n == null) return;

        s += n.val;

        if (n.left == null && n.right == null) {
            ans.add(s);
            return;
        }

        s += "->";
        dfs(n.left, s, ans);
        dfs(n.right, s, ans);
    }
}