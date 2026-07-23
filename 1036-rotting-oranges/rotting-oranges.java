class Solution {
    public int orangesRotting(int[][] g) {
        int m = g.length, n = g[0].length, f = 0, t = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] d = {0, 1, 0, -1, 0};

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (g[i][j] == 2) q.offer(new int[]{i, j});
                else if (g[i][j] == 1) f++;

        while (!q.isEmpty() && f > 0) {
            for (int s = q.size(); s > 0; s--) {
                int[] c = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = c[0] + d[k], y = c[1] + d[k + 1];
                    if (x >= 0 && y >= 0 && x < m && y < n && g[x][y] == 1) {
                        g[x][y] = 2;
                        f--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            t++;
        }
        return f == 0 ? t : -1;
    }
}