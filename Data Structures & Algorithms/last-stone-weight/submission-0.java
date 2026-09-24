class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        Queue<Integer> pq = new PriorityQueue<>();
        for (int stone : stones) pq.add(-stone);

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first < second) pq.add(second - first);
            else if (first > second) pq.add(first - second);
        }
        return pq.poll();
    }
}
