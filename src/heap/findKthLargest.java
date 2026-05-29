package src.heap;

import java.util.PriorityQueue;

public class findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.poll();
    }
}
