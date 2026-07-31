class Solution {
    public int minimumPushes(String word) {
        int[] f = new int[26];
        for (char c : word.toCharArray()) f[c - 'a']++;
        Arrays.sort(f);
        int ans = 0, k = 0;
        for (int i = 25; i >= 0; i--) {
            if (f[i] == 0) break;
            ans += f[i] * (k / 8 + 1);
            k++;
        }
        return ans;
    }
}