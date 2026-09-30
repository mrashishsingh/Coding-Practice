class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int d = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                d++;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }

        return ans;
    }
}