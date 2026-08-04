package src.linkedlist;

import src.ListNode;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){//carry！=0代表还有进位
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;//下一个节点
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;//下一个节点
            }
            cur= cur.next=new ListNode(sum%10);
            carry=sum/=10;//新的进位
        }
        return dummy.next;
    }
}
