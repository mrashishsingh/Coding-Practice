import java.util.*;

class Solution {
    public boolean uniformArray(int[] a) {
        Arrays.sort(a);
        return check(a, 0) || check(a, 1);
    }

    boolean check(int[] a, int t) {
        boolean[] s = new boolean[2];

        for (int x : a) {
            int p = x & 1;
            if (p != t && !s[p ^ t]) return false;
            s[p] = true;
        }

        return true;
    }
}