class Solution {
    public int sumOfLeftLeaves(TreeNode r) {
        if (r == null) return 0;
        int s = 0;
        if (r.left != null) {
            if (r.left.left == null && r.left.right == null)
                s += r.left.val;
            else
                s += sumOfLeftLeaves(r.left);
        }
        s += sumOfLeftLeaves(r.right);
        return s;
    }
}