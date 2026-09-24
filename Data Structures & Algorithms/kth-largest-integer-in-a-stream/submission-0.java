class KthLargest {
    Queue<Integer> pq;
    int position;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        position = k;

        for (int num : nums) pq.add(num);
    }
    
    public int add(int val) {
        pq.add(val);
        Queue<Integer> clone = new PriorityQueue<>(pq);
        for (int i = 0; i < pq.size() - position; i++) {
            clone.poll();
        }
        return clone.poll();
    }
}
