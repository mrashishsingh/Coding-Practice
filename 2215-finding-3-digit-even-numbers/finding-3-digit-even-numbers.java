class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] c = new int[10];
        for (int d : digits) c[d]++;

        List<Integer> a = new ArrayList<>();

        for (int i = 100; i <= 998; i += 2) {
            int x = i;
            int[] t = new int[10];
            t[x % 10]++;
            x /= 10;
            t[x % 10]++;
            x /= 10;
            t[x]++;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                if (t[j] > c[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok) a.add(i);
        }

        int[] r = new int[a.size()];
        for (int i = 0; i < a.size(); i++) r[i] = a.get(i);
        return r;
    }
}