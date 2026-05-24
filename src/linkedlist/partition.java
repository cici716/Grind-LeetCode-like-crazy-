package src.linkedlist;

import src.ListNode;

public class partition {
    public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(0);
        ListNode smallhead = small; //哑节点 方便处理头结点为空的边界条件
        ListNode large=new ListNode(0);
        ListNode largehead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small=small.next;
            }else  {
                large.next = head;
                large=large.next;
            }
            head = head.next;
        }
        small.next = largehead.next;
        large.next = null;
        return smallhead.next;
    }
}
