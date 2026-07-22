class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode t = root.left;
                while (t.right != null)
                    t = t.right;
                t.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}