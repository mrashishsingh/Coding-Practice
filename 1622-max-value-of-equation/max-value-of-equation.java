class Solution {
    public int findMaxValueOfEquation(int[][] p, int k) {
        java.util.Deque<int[]> q=new java.util.ArrayDeque<>();
        int r=Integer.MIN_VALUE;
        for(int[] a:p){
            while(!q.isEmpty()&&a[0]-q.peek()[0]>k)q.poll();
            if(!q.isEmpty())r=Math.max(r,a[0]+a[1]+q.peek()[1]);
            int v=a[1]-a[0];
            while(!q.isEmpty()&&q.peekLast()[1]<=v)q.pollLast();
            q.offer(new int[]{a[0],v});
        }
        return r;
    }
}