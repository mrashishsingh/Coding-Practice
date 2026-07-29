class Solution {
    static final int LIM = 1000000;

    public String smallestPalindrome(String s, int k) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;

        int[] cnt = new int[26];
        char mid = 0;
        int len = 0;

        for (int i = 0; i < 26; i++) {
            cnt[i] = f[i] / 2;
            len += cnt[i];
            if ((f[i] & 1) == 1) mid = (char) ('a' + i);
        }

        List<Integer> primes = sieve(len);

        if (ways(cnt, primes) < k) return "";

        StringBuilder left = new StringBuilder();

        while (len > 0) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == 0) continue;
                cnt[i]--;
                int w = ways(cnt, primes);
                if (k > w) {
                    k -= w;
                    cnt[i]++;
                } else {
                    left.append((char) ('a' + i));
                    len--;
                    break;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) ans.append(mid);
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();
    }

    List<Integer> sieve(int n) {
        boolean[] vis = new boolean[n + 1];
        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) {
                p.add(i);
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) vis[j] = true;
                }
            }
        }
        return p;
    }

    int ways(int[] cnt, List<Integer> primes) {
        int tot = 0;
        for (int x : cnt) tot += x;

        long res = 1;

        for (int p : primes) {
            int e = exp(tot, p);
            for (int x : cnt) e -= exp(x, p);

            while (e-- > 0) {
                res *= p;
                if (res > LIM) return LIM + 1;
            }
        }
        return (int) res;
    }

    int exp(int n, int p) {
        int r = 0;
        while (n > 0) {
            n /= p;
            r += n;
        }
        return r;
    }
}