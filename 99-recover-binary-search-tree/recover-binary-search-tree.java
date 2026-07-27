class Solution {
    TreeNode f, s, p;

    public void recoverTree(TreeNode root) {
        t(root);
        int x = f.val;
        f.val = s.val;
        s.val = x;
    }

    void t(TreeNode r) {
        if (r == null) return;
        t(r.left);
        if (p != null && p.val > r.val) {
            if (f == null) f = p;
            s = r;
        }
        p = r;
        t(r.right);
    }
}