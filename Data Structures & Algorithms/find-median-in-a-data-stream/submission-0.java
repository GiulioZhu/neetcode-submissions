class MedianFinder {
    int size;
    Queue<Integer> data_stream;

    public MedianFinder() {
        size = 0;
        data_stream = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        data_stream.add(num);
        size++;
    }
    
    public double findMedian() {
        Queue<Integer> copy = new PriorityQueue<>(data_stream);
        int median = size/2;
        double num = 0;
        for (int i = 0; i < median; i++) {
            num = copy.poll();
        }
        if (size%2 == 0) {
            return (num + copy.poll())/2.0;
        }
        return copy.poll();
    }
}
