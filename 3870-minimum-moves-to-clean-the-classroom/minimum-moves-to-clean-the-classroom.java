import java.util.*;

class Solution {
    public int minMoves(String[] a, int e) {
        int m=a.length,n=a[0].length(),sr=0,sc=0,k=0;
        int[][] id=new int[m][n];
        for(int[] x:id) Arrays.fill(x,-1);

        for(int i=0;i<m;i++) for(int j=0;j<n;j++) {
            char c=a[i].charAt(j);
            if(c=='S'){sr=i;sc=j;}
            if(c=='L') id[i][j]=k++;
        }

        int all=(1<<k)-1;
        boolean[][][][] v=new boolean[m][n][e+1][1<<k];
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc,e,0});
        v[sr][sc][e][0]=true;

        int[] dr={1,-1,0,0},dc={0,0,1,-1};
        int ans=0;

        while(!q.isEmpty()){
            int z=q.size();
            while(z-->0){
                int[] d=q.poll();
                int r=d[0],c=d[1],en=d[2],mask=d[3];
                if(mask==all) return ans;
                if(en==0) continue;

                for(int x=0;x<4;x++){
                    int nr=r+dr[x],nc=c+dc[x];
                    if(nr<0||nr>=m||nc<0||nc>=n||a[nr].charAt(nc)=='X') continue;

                    int ne=en-1,nm=mask;
                    char ch=a[nr].charAt(nc);
                    if(ch=='L') nm|=1<<id[nr][nc];
                    if(ch=='R') ne=e;

                    if(!v[nr][nc][ne][nm]){
                        v[nr][nc][ne][nm]=true;
                        q.add(new int[]{nr,nc,ne,nm});
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}