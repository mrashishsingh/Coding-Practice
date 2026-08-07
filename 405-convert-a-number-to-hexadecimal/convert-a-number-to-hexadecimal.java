class Solution {
    public String toHex(int n) {
        if (n == 0) return "0";
        char[] h = "0123456789abcdef".toCharArray();
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s.append(h[n & 15]);
            n >>>= 4;
        }
        return s.reverse().toString();
    }
}