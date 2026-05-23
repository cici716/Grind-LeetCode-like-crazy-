package src.linkedlist;

import src.ListNode;

public class deleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while(cur.next!=null&&cur.next.next!=null){
            int value=cur.next.val;
            if(value==cur.next.next.val){
                while (cur.next!=null && cur.next.val==value){//只要下一个节点还在并且值等于当前值 就将它删掉

                    cur.next=cur.next.next;
                }

            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
