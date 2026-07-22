class Solution {
    int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ans;
    }

    int[] dfs(TreeNode root, int d) {
        int[] a = new int[d + 1];
        if (root == null) return a;

        if (root.left == null && root.right == null) {
            a[1] = 1;
            return a;
        }

        int[] l = dfs(root.left, d);
        int[] r = dfs(root.right, d);

        for (int i = 1; i <= d; i++)
            for (int j = 1; j <= d; j++)
                if (i + j <= d) ans += l[i] * r[j];

        for (int i = 2; i <= d; i++)
            a[i] = l[i - 1] + r[i - 1];

        return a;
    }
}