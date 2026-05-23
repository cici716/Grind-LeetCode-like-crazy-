package src.linkedlist;

import src.ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode l=dummy;
        ListNode r=dummy;

        for(int i=0;i<n;i++) {
            r=r.next;
        }
        while(r.next!=null) {
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;
        return dummy.next;
    }
}
