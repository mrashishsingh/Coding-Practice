public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int x = guess(m);

            if (x == 0) return m;
            if (x == 1) l = m + 1;
            else r = m - 1;
        }

        return -1;
    }
}