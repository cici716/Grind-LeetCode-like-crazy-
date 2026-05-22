package src.linkedlist;

import src.ListNode;

import java.util.HashSet;
import java.util.Set;

public class detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode pos=head;
        Set<ListNode> set=new HashSet<>();
        while (pos!=null){
            if(set.contains(pos)){
                return pos;
            }else  {
                set.add(pos);
                pos=pos.next;
            }
        }
        return null;
    }

}
