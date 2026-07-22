class Solution {
    List<Integer> a=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode r) {
        if(r!=null){
            postorderTraversal(r.left);
            postorderTraversal(r.right);
            a.add(r.val);
        }
        return a;
    }
}