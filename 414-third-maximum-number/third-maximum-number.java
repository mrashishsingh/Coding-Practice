class Solution {
    public int thirdMax(int[] a) {
        Long x = null, y = null, z = null;
        for (int n : a) {
            long v = n;
            if ((x != null && v == x) || (y != null && v == y) || (z != null && v == z)) continue;
            if (x == null || v > x) {
                z = y;
                y = x;
                x = v;
            } else if (y == null || v > y) {
                z = y;
                y = v;
            } else if (z == null || v > z) {
                z = v;
            }
        }
        return z == null ? x.intValue() : z.intValue();
    }
}