class Solution {
    public String smallestPalindrome(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;

        StringBuilder l = new StringBuilder();
        char m = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < f[i] / 2; j++) {
                l.append((char) (i + 'a'));
            }
            if ((f[i] & 1) == 1) m = (char) (i + 'a');
        }

        StringBuilder r = new StringBuilder(l).reverse();

        if (m != 0) l.append(m);
        l.append(r);

        return l.toString();
    }
}