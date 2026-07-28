class Solution {
    public double[] calcEquation(List<List<String>> e, double[] v, List<List<String>> q) {
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < e.size(); i++) {
            String a = e.get(i).get(0), b = e.get(i).get(1);
            g.computeIfAbsent(a, k -> new HashMap<>()).put(b, v[i]);
            g.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / v[i]);
        }

        double[] ans = new double[q.size()];
        for (int i = 0; i < q.size(); i++) {
            String s = q.get(i).get(0), t = q.get(i).get(1);
            if (!g.containsKey(s) || !g.containsKey(t)) ans[i] = -1;
            else if (s.equals(t)) ans[i] = 1;
            else ans[i] = dfs(s, t, 1, g, new HashSet<>());
        }
        return ans;
    }

    double dfs(String s, String t, double p, Map<String, Map<String, Double>> g, Set<String> vis) {
        if (s.equals(t)) return p;
        vis.add(s);
        for (var e : g.get(s).entrySet()) {
            if (!vis.contains(e.getKey())) {
                double r = dfs(e.getKey(), t, p * e.getValue(), g, vis);
                if (r != -1) return r;
            }
        }
        return -1;
    }
}