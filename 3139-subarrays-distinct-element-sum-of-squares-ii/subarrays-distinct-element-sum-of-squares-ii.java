import java.util.Arrays;

class Solution {

    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] square;
    private long[] lazy;

    public int sumCounts(int[] nums) {

        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        long res = 0;

        for (int i = 0; i < n; i++) {

            int prev = last[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            res = (res + square[1]) % MOD;

            last[nums[i]] = i;
        }

        return (int) res;
    }

    private void update(int node, int start, int end,
                        int left, int right) {

        if (right < start || end < left) {
            return;
        }

        if (left <= start && end <= right) {
            apply(node, end - start + 1, 1);
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);

        update(node * 2 + 1, mid + 1, end, left, right);

        sum[node] = (sum[node * 2]
                   + sum[node * 2 + 1]) % MOD;

        square[node] = (square[node * 2]
                      + square[node * 2 + 1]) % MOD;
    }

    private void apply(int node, int len, long value) {

        value %= MOD;

        square[node] = (
                square[node]
                + 2 * value % MOD * sum[node] % MOD
                + value * value % MOD * len % MOD
        ) % MOD;

        sum[node] = (sum[node] + value * len) % MOD;

        lazy[node] += value;
    }

    private void push(int node, int start, int end) {

        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(node * 2, mid - start + 1, lazy[node]);

        apply(node * 2 + 1, end - mid, lazy[node]);

        lazy[node] = 0;
    }
}