class Solution {
    Queue<Double> pq = new PriorityQueue<>();
    HashMap<Double, List<Integer[]>> map = new HashMap<>();
    int[][] ans;
    
    public int[][] kClosest(int[][] points, int k) {
        ans = new int[k][2];
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance = (double) Math.sqrt(x * x + y * y);

            Integer[] new_p = new Integer[2]; new_p[0] = x; new_p[1] = y;
            List<Integer[]> list;
            if (!map.containsKey(distance)) list = new ArrayList<>(); 
            else list = map.get(distance);
            list.add(new_p);
            map.put(distance, list);
            pq.add(distance);
        }

        for (int i = 0; i < k; i++) {
            Double distance = pq.poll();
            List<Integer[]> list = map.get(distance);
            Integer[] point = list.get(0);
            list.remove(0);
            map.put(distance, list);
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }
        return ans;
    }
}
