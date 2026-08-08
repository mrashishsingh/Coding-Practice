import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        ArrayList<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

        for (int i = 0; i < n; i++)
            pos[word1.charAt(i) - 'a'].add(i);

        int[] r0 = new int[m];
        Arrays.fill(r0, -1);

        int lim = n;
        for (int j = m - 1; j >= 0; j--) {
            ArrayList<Integer> a = pos[word2.charAt(j) - 'a'];
            int k = lowerBound(a, lim) - 1;

            if (k < 0) break;

            r0[j] = a.get(k);
            lim = r0[j];
        }

        int[] r1 = new int[m];
        Arrays.fill(r1, -1);
        r1[m - 1] = n - 1;

        for (int j = m - 2; j >= 0; j--) {
            int c = word2.charAt(j) - 'a';

            int x = -1;
            ArrayList<Integer> a = pos[c];
            int k = lowerBound(a, r1[j + 1]) - 1;
            if (k >= 0) x = a.get(k);

            int y = -1;
            if (r0[j + 1] != -1) {
                for (int z = 0; z < 26; z++) {
                    if (z == c) continue;
                    ArrayList<Integer> b = pos[z];
                    int t = lowerBound(b, r0[j + 1]) - 1;
                    if (t >= 0)
                        y = Math.max(y, b.get(t));
                }
            }

            r1[j] = Math.max(x, y);
        }

        int[] ans = new int[m];
        int last = -1;
        boolean used = false;

        for (int j = 0; j < m; j++) {
            boolean found = false;
            int c = word2.charAt(j) - 'a';

            for (int i = last + 1; i < n; i++) {
                boolean same = word1.charAt(i) - 'a' == c;
                boolean ok;

                if (same) {
                    if (j == m - 1)
                        ok = true;
                    else
                        ok = (used ? r0[j + 1] : r1[j + 1]) > i;
                } else {
                    if (used)
                        ok = false;
                    else
                        ok = j == m - 1 || r0[j + 1] > i;
                }

                if (ok) {
                    ans[j] = i;
                    last = i;
                    if (!same) used = true;
                    found = true;
                    break;
                }
            }

            if (!found) return new int[0];
        }

        return ans;
    }

    private int lowerBound(ArrayList<Integer> a, int x) {
        int l = 0, r = a.size();

        while (l < r) {
            int mid = (l + r) >>> 1;

            if (a.get(mid) < x)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }
}