class BSTIterator {
    Stack<TreeNode> s=new Stack<>();
    
    public BSTIterator(TreeNode r) {
        while(r!=null){
            s.push(r);
            r=r.left;
        }
    }
    
    public int next() {
        TreeNode t=s.pop();
        int x=t.val;
        t=t.right;
        while(t!=null){
            s.push(t);
            t=t.left;
        }
        return x;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}