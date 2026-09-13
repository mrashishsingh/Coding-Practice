class Solution {
    public int largestOverlap(int[][] a, int[][] b) {
        int n = a.length, ans = 0;

        for (int dx = -n + 1; dx < n; dx++) {
            for (int dy = -n + 1; dy < n; dy++) {
                int c = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int x = i + dx, y = j + dy;
                        if (x >= 0 && x < n && y >= 0 && y < n && a[i][j] == 1 && b[x][y] == 1)
                            c++;
                    }
                }

                ans = Math.max(ans, c);
            }
        }

        return ans;
    }
}