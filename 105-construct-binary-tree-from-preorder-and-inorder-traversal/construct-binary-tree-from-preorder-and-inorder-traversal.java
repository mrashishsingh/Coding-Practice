class Solution {
    int i = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int j = 0; j < inorder.length; j++)
            map.put(inorder[j], j);
        return build(preorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] pre, int l, int r) {
        if (l > r) return null;
        TreeNode root = new TreeNode(pre[i++]);
        int m = map.get(root.val);
        root.left = build(pre, l, m - 1);
        root.right = build(pre, m + 1, r);
        return root;
    }
}