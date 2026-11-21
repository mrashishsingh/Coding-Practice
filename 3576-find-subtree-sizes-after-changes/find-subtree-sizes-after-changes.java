class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        List<List<Integer>>child=new ArrayList<>();
        for(int i=0;i<n;i++){
            child.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            child.get(parent[i]).add(i);
        }
        int[]newParent=parent.clone();
        Deque<Integer>[]dq=new ArrayDeque[26];
        for(int i=0;i<26;i++){
            dq[i]=new ArrayDeque<>();
        }
        dfs(0,child,s,newParent,dq);
            List<List<Integer>>newChildren=new ArrayList<>();
        for(int i=0;i<n;i++){
               newChildren.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            newChildren.get(newParent[i]).add(i);
        }
        int []ans=new int[n];
        computeSize(0,newChildren,ans);
        return ans;
    }
    public static void dfs(int node,List<List<Integer>>child,String s,int[]newParent,Deque<Integer>[]dq){
        int ch=s.charAt(node)-'a';
        if(!dq[ch].isEmpty()){
            newParent[node]=dq[ch].peek();
        }
        dq[ch].push(node);
        for(int nbrs:child.get(node)){
            dfs(nbrs,child,s,newParent,dq);
        }
        dq[ch].pop();
    }
    public static int computeSize(int node,List<List<Integer>>child,int[]ans){
        int size=1;
        for(int nbrs:child.get(node)){
            size+=computeSize(nbrs,child,ans);
        }
        ans[node]=size;
        return size;
    }
}