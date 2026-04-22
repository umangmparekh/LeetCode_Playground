package crowdstrike;

import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> maxHeap;

    private final PriorityQueue<Integer> minHeap;

    public MedianFinder(){
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(Integer num){
        // Step 1 : by default add to MaxHeap
        maxHeap.offer(num);

        // step 2 :
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }

        // Step 3 : Rebalance Heap
        if(maxHeap.size() > minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()+1){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        return (double) maxHeap.peek();
    }

    public static void main(String[] args){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        System.out.println("After adding number 1 >> "+mf.findMedian());
        mf.addNum(2);
        System.out.println("After adding number 2 >> "+mf.findMedian());
        mf.addNum(3);
        System.out.println("After adding number 3 >> "+mf.findMedian());
        mf.addNum(4);
        System.out.println("After adding number 4 >> "+mf.findMedian());
        mf.addNum(5);
        System.out.println("After adding number 5 >> "+mf.findMedian());
        mf.addNum(6);
        System.out.println("After adding number 6 >> "+mf.findMedian());
    }
}
