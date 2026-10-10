class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] d = new int[n];
        long sum = 0;
        int mx = 0;

        for (int i = 0; i < n; i++) {
            d[i] = Math.abs(nums1[i] - nums2[i]);
            sum += d[i];
            mx = Math.max(mx, d[i]);
        }

        long k = (long) k1 + k2;

        if (k >= sum) return 0;

        int l = 0, r = mx;

        while (l < r) {
            int m = l + (r - l) / 2;
            long cnt = 0;

            for (int x : d) {
                if (x > m) cnt += x - m;
            }

            if (cnt <= k) r = m;
            else l = m + 1;
        }

        long ans = 0;
        long used = 0;

        for (int x : d) {
            int y = Math.min(x, l);
            ans += (long) y * y;
            used += x - y;
        }

        long rem = k - used;
        return ans - rem * (2L * l - 1);
    }
}