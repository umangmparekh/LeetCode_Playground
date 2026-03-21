package Intuit;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder(){
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num){
        if(maxHeap.isEmpty() || maxHeap.peek() > num){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        int size1= minHeap.size(),  size2=maxHeap.size();
        if (size1 - size2 == 2) {
            maxHeap.add(minHeap.remove());
        } else if (size2 - size1 == 2) {
            minHeap.add(maxHeap.remove());
        }
    }
    public double findMedian() {
        int size1 = minHeap.size(), size2 = maxHeap.size();
        if(size1 == size2) {
            return (minHeap.peek()+maxHeap.peek()) / 2.0;
        } else {
            if(size1 > size2){
                return (double) minHeap.peek();
            }else {
                return (double) maxHeap.peek();
            }
        }
    }

    }
