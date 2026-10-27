class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            char[] a = new char[n];
            java.util.Arrays.fill(a, '#');

            if (i == 0) {
                java.util.Arrays.fill(a, '.');
            } else {
                a[n - 1] = '.';
            }

            ans[i] = new String(a);
        }

        return ans;
    }
}