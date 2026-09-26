class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(-num);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return -pq.poll();
    }
}
