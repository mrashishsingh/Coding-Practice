class Solution {
    public boolean containsNearbyDuplicate(int[] a, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (m.containsKey(a[i]) && i - m.get(a[i]) <= k) return true;
            m.put(a[i], i);
        }
        return false;
    }
}