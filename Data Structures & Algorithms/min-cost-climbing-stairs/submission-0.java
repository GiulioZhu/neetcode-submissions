class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] min = new int[cost.length + 2];
        min[0] = cost[0];
        min[1] = cost[1];

        for (int i = 2; i < min.length; i++) {
            int c = 0;
            if (i < cost.length) c = cost[i];;
            min[i] = c + Math.min(min[i-2], min[i-1]);
        }
        return Math.min(min[cost.length], min[cost.length+1]);
    }
}
