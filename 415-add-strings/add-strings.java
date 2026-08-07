class Solution {
    public String addStrings(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c > 0) {
            int x = i >= 0 ? a.charAt(i--) - '0' : 0;
            int y = j >= 0 ? b.charAt(j--) - '0' : 0;
            int t = x + y + c;
            s.append(t % 10);
            c = t / 10;
        }
        return s.reverse().toString();
    }
}