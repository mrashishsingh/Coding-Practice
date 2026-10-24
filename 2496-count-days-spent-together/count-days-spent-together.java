class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int a = Math.max(arriveAlice.compareTo(arriveBob) >= 0 ? date(arriveAlice) : date(arriveBob),
                         date(arriveAlice));
        int b = Math.min(date(leaveAlice), date(leaveBob));
        return Math.max(0, b - a + 1);
    }

    public int date(String s) {
        int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m = Integer.parseInt(s.substring(0, 2));
        int day = Integer.parseInt(s.substring(3));
        for (int i = 0; i < m - 1; i++) {
            day += d[i];
        }
        return day;
    }
}