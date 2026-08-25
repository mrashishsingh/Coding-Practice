class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] a = new boolean[101];

        for (int x : nums) {
            if (x <= 100)
                a[x] = true;
        }

        for (int i = k; ; i += k) {
            if (i > 100 || !a[i])
                return i;
        }
    }
}