package src.heap;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size()+1) {
            minHeap.offer(maxHeap.poll());
        }else if (minHeap.size() >maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size()>minHeap.size()) {
            return (double)maxHeap.peek();
        }else {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}
