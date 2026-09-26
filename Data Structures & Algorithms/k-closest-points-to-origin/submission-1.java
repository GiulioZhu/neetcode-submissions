class Solution {
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    int[][] ans;
    
    public int[][] kClosest(int[][] points, int k) {
        ans = new int[k][2];
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int distance = x * x + y * y;
            pq.add(new int[]{distance, x, y});
        }

        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();
            ans[i][0] = point[1];
            ans[i][1] = point[2];
        }
        return ans;
    }
}
