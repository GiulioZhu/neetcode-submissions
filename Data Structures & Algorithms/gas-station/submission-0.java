class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = 0;
        int r = 0;
        int step = 0;
        int remaining = 0;

        while(l < gas.length) {
            if (step == gas.length) return l;
            remaining += gas[r] - cost[r];
            if (remaining < 0) {
                l++;
                r = l;
                step = 0;
                remaining = 0;
                // restart
            } else {
                step++;
                r++;
                if (r >= gas.length) r = 0;
            }
        }
        return -1;
    }
}
