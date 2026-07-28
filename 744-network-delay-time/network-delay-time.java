class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] t : times) g[t[0]].add(new int[]{t[1], t[2]});

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], dis = cur[1];
            if (dis > d[u]) continue;

            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (d[v] > dis + w) {
                    d[v] = dis + w;
                    pq.offer(new int[]{v, d[v]});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, d[i]);
        }
        return ans;
    }
}