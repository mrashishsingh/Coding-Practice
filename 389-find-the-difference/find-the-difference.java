class Solution {
    public char findTheDifference(String s, String t) {
        char a = 0;

        for (char c : s.toCharArray())
            a ^= c;

        for (char c : t.toCharArray())
            a ^= c;

        return a;
    }
}