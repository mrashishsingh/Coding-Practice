class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] t = d.clone();
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (d[u] != Integer.MAX_VALUE && t[v] > d[u] + w)
                    t[v] = d[u] + w;
            }
            d = t;
        }

        return d[dst] == Integer.MAX_VALUE ? -1 : d[dst];
    }
}