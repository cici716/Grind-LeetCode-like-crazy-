package src.linkedlist;


import src.ListNode;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next==null) {
            return head;
        }
        ListNode reverse_head=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return reverse_head;
    }
}
