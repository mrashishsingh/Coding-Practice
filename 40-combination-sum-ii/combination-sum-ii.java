class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(int[] a, int t, int start, List<Integer> cur, List<List<Integer>> res) {
        if (t == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < a.length; i++) {
            if (i > start && a[i] == a[i - 1]) continue;
            if (a[i] > t) break;

            cur.add(a[i]);
            backtrack(a, t - a[i], i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}