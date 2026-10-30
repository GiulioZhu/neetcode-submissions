class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        PriorityQueue<Integer> pq;

        int i = 0;
        int j = k-1;
        for (int index = i; index <= j; index++) {
            dq.add(-nums[index]);
        }
        pq = new PriorityQueue<>(dq);
        max[i] = -pq.peek();
        i++;
        j++;


        while(j < nums.length) {
            dq.poll();
            dq.addLast(-nums[j]);
            pq = new PriorityQueue<>(dq);
            max[i] = -pq.peek();
            i++;
            j++;
        }
        return max;
    }
}
