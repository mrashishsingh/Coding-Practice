class Solution {
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1 && !s.contains(n)) {
            s.add(n);
            int x = 0;
            while (n > 0) {
                int d = n % 10;
                x += d * d;
                n /= 10;
            }
            n = x;
        }
        return n == 1;
    }
}