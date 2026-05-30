package src.heap;

import org.junit.Test;
import src.ListNode;

import java.util.PriorityQueue;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((a,b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        //创建一个dummy
        ListNode dummyHead = new ListNode(0),curr = dummyHead;
        while (!queue.isEmpty()) {
            ListNode top = queue.poll();
            curr.next=top;
            curr=curr.next;
            if (top.next != null)
                queue.offer(top.next);
        }
        return dummyHead.next;
    }

    @Test
    public void test(){
        // 第一条链表：1 -> 4 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        // 第二条链表：1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // 第三条链表：2 -> 6
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        ListNode result = mergeKLists(lists);

        printList(result);

    }
    private void printList(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }

            curr = curr.next;
        }

        System.out.println();
    }


}





