package src.linkedlist;

import src.ListNode;

public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //统计节点个数
        int n=0;
        for (ListNode cur=head; cur!=null; cur=cur.next) {
            n++;
        }

        ListNode dummy=new ListNode(0,head);
        ListNode lastTail=dummy;//上一组反转后尾节点

        //k个一组处理
        for (;n>=k;n-=k){
            ListNode pre=null;
            ListNode cur=lastTail.next;
            for (int i=0;i<k;i++){
                ListNode nxt=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nxt;
            }
            ListNode tail=lastTail.next;
            tail.next=cur;  //当前组的尾节点指向下一组的起始节点
            lastTail.next=pre;//上一组的尾节点指向当前组的头结点
            lastTail=tail;
        }
        return dummy.next;
    }
}
