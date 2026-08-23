class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;

        while (l <= r) {
            long m = l + (r - l) / 2;
            long x = m * m;

            if (x == num)
                return true;
            if (x < num)
                l = m + 1;
            else
                r = m - 1;
        }

        return false;
    }
}