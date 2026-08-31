class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, prev = -1, min = Integer.MAX_VALUE;
        int i = 1;
        ListNode a = head, b = head.next;

        while (b.next != null) {
            if ((b.val > a.val && b.val > b.next.val) ||
                (b.val < a.val && b.val < b.next.val)) {
                if (first == -1) first = i;
                if (prev != -1) min = Math.min(min, i - prev);
                prev = i;
            }
            a = b;
            b = b.next;
            i++;
        }

        if (first == -1 || first == prev) return new int[]{-1, -1};
        return new int[]{min, prev - first};
    }
}