class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (!head) return head;

        ListNode* dummy = new ListNode(0);
        dummy->next = head;

        ListNode* prev = dummy;
        ListNode* greater = head;

        while (greater && greater->val < x) {
            prev = greater;
            greater = greater->next;
        }

        if (!greater) return head;

        ListNode* newprev = greater;
        ListNode* temp = greater->next;

        while (temp) {
            if (temp->val < x){
                newprev->next = temp->next;
                prev->next = temp;
                temp->next = greater;
                prev = temp;
                temp = newprev->next;
            } else {
                newprev = temp;
                temp = temp->next;
            }
        }

        return dummy->next;
    }
};