package src.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //用map occurs统计数字出现次数
        Map<Integer, Integer> occurs = new HashMap<>();
        for (int num : nums) {
            occurs.put(num, occurs.getOrDefault(num, 0) + 1);
        }
        //用堆获取前k个出现最多的字母 注意：此时是以键值对的形式存入堆  排序是按照键值对的值也就是出现次数
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a, b) ->a.getValue() - b.getValue());
        for (Map.Entry<Integer,Integer> entry : occurs.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        //遍历堆 取出键值对中的键
        int [] ans=new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll().getKey();
        }
        return ans;

    }
}
