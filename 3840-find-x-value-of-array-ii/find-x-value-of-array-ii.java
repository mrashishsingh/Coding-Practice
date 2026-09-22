class Solution {
    int k;
    Node[] t;

    class Node {
        int p;
        long[] c = new long[k];
    }

    Node merge(Node a, Node b) {
        Node r = new Node();
        r.p = a.p * b.p % k;

        for (int i = 0; i < k; i++)
            r.c[i] = a.c[i];

        for (int i = 0; i < k; i++)
            r.c[a.p * i % k] += b.c[i];

        return r;
    }

    void build(int o, int l, int r, int[] a) {
        if (l == r) {
            t[o] = new Node();
            t[o].p = a[l] % k;
            t[o].c[t[o].p] = 1;
            return;
        }

        int m = (l + r) / 2;
        build(o * 2, l, m, a);
        build(o * 2 + 1, m + 1, r, a);
        t[o] = merge(t[o * 2], t[o * 2 + 1]);
    }

    void update(int o, int l, int r, int i, int v) {
        if (l == r) {
            t[o] = new Node();
            t[o].p = v % k;
            t[o].c[t[o].p] = 1;
            return;
        }

        int m = (l + r) / 2;

        if (i <= m)
            update(o * 2, l, m, i, v);
        else
            update(o * 2 + 1, m + 1, r, i, v);

        t[o] = merge(t[o * 2], t[o * 2 + 1]);
    }

    Node query(int o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr)
            return t[o];

        int m = (l + r) / 2;

        if (qr <= m)
            return query(o * 2, l, m, ql, qr);

        if (ql > m)
            return query(o * 2 + 1, m + 1, r, ql, qr);

        return merge(
            query(o * 2, l, m, ql, qr),
            query(o * 2 + 1, m + 1, r, ql, qr)
        );
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        t = new Node[4 * nums.length];

        build(1, 0, nums.length - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            update(1, 0, nums.length - 1,
                   queries[i][0], queries[i][1]);

            ans[i] = (int) query(
                1, 0, nums.length - 1,
                queries[i][2], nums.length - 1
            ).c[queries[i][3]];
        }

        return ans;
    }
}