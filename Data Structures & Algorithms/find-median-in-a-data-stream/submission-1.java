class MedianFinder {
    int size;
    Queue<Integer> max_heap;
    Queue<Integer> min_heap;

    public MedianFinder() {
        size = 0;
        max_heap = new PriorityQueue<>();
        min_heap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (min_heap.size() == 0 || num > min_heap.peek()) min_heap.add(num);
        else max_heap.add(-num);


        if (max_heap.size() - min_heap.size() > 1) min_heap.add(-max_heap.poll());
        if (min_heap.size() - max_heap.size() > 1) max_heap.add(-min_heap.poll());
        size++;
    }
    
    public double findMedian() {
        if (size%2 == 0) return (min_heap.peek() + -max_heap.peek())/2.0;
        if (max_heap.size() > min_heap.size()) return -max_heap.peek();
        return min_heap.peek();
    }
}
