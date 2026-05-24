package src.linkedlist;

import src.ListNode;

public class swapPairs {
    public ListNode swapPairs(ListNode head) {
     ListNode dummy=new ListNode(0,head);
     ListNode prev=dummy;
     ListNode first=head;

     while(first!=null&&first.next!=null){
      ListNode second=first.next;
      ListNode nxt=second.next;

      prev.next=second;
      second.next=first;
      first.next=nxt;

      prev=first;
      first=nxt;//移动链表，注意这里是移动两步，即交换完的两步
     }
     return dummy.next;
    }
}
