class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i = 0; i < n; i++) {
            int ind = s.charAt(i) - 'a';

            if(first[ind] == -1)
                first[ind] = i;

            last[ind] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            if(first[i] == -1) continue;

            int l = first[i], r = last[i], ok = 1;

            for(int j = l; j <= r; j++) {
                int currind = s.charAt(j) - 'a';

                if(first[currind] < l) {
                    ok = 0;
                    break;
                }

                r = Math.max(r, last[currind]);
            }

            if(ok == 1)
                intervals.add(new int[]{r, l});
        }

        intervals.sort((a, b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int prev = -1;
        List<String> ans = new ArrayList<>();

        for(int[] it : intervals) {
            int l = it[1], r = it[0];

            if(prev == -1 || prev < l) {
                ans.add(s.substring(l, r + 1));
                prev = r;
            }
        }

        return ans;
    }
}