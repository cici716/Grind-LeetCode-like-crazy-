package src.linkedlist;

import src.ListNode;

public class sortList {
    public ListNode sortList(ListNode head) {
    //edge case
        if(head==null||head.next==null)return head;
        //快慢指针找链表中间节点
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //断开链表为两段
        ListNode mid=slow.next;
        slow.next=null;
        slow=sortList(slow);
        // 递归排序左半部分和右半部分
        ListNode left=sortList(head);
        ListNode right= sortList(mid);
        //合并两个有序列表
        return merge( left,right);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;
        while (l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next; //注意这里是l1不是cur
            }else {
                cur.next=l2;
               l2=l2.next;
            }
            cur=cur.next;
                // 拼接剩余未拼完的链表部分
            if (l1!=null) cur.next=l1;
            if (l2!=null) cur.next=l2;
        }
        return dummy.next;
    }


}
