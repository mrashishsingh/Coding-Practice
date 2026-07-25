class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length,r[]=new int[n-k+1],l=0;
        java.util.Deque<Integer> q=new java.util.ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&q.peek()<i-k+1)q.poll();
            while(!q.isEmpty()&&a[q.peekLast()]<=a[i])q.pollLast();
            q.offer(i);
            if(i>=k-1)r[l++]=a[q.peek()];
        }
        return r;
    }
}