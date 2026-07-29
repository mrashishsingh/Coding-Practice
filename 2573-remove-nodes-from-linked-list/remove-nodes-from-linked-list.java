class Solution {
    public ListNode removeNodes(ListNode head) {
        head = rev(head);
        int mx = 0;
        ListNode d = new ListNode(0), t = d;

        while (head != null) {
            if (head.val >= mx) {
                mx = head.val;
                t.next = head;
                t = head;
            }
            head = head.next;
        }

        t.next = null;
        return rev(d.next);
    }

    ListNode rev(ListNode h) {
        ListNode p = null;
        while (h != null) {
            ListNode n = h.next;
            h.next = p;
            p = h;
            h = n;
        }
        return p;
    }
}