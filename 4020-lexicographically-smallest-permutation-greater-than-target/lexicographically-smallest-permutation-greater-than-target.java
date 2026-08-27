class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] c = new int[26];

        for (char x : s.toCharArray())
            c[x - 'a']++;

        int i = 0;

        while (i < target.length() && c[target.charAt(i) - 'a'] > 0) {
            c[target.charAt(i) - 'a']--;
            i++;
        }

        while (i >= 0) {
            if (i < target.length()) {
                int x = target.charAt(i) - 'a';

                for (int j = x + 1; j < 26; j++) {
                    if (c[j] > 0) {
                        int[] d = c.clone();
                        d[j]--;

                        StringBuilder r = new StringBuilder(target.substring(0, i));
                        r.append((char)('a' + j));

                        for (int k = 0; k < 26; k++) {
                            while (d[k]-- > 0)
                                r.append((char)('a' + k));
                        }

                        return r.toString();
                    }
                }
            }

            i--;

            if (i >= 0)
                c[target.charAt(i) - 'a']++;
        }

        return "";
    }
}