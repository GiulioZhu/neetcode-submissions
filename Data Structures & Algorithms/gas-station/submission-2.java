class Solution {
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     int l = 0;
    //     int r = 0;
    //     int step = 0;
    //     int remaining = 0;

    //     while(l < gas.length) {
    //         if (step == gas.length) return l;
    //         remaining += gas[r] - cost[r];
    //         if (remaining < 0) {
    //             l++;
    //             r = l;
    //             step = 0;
    //             remaining = 0;
    //             // restart
    //         } else {
    //             step++;
    //             r++;
    //             if (r >= gas.length) r = 0;
    //         }
    //     }
    //     return -1;
    // }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remainings = new int[gas.length];
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            remainings[i] = gas[i] - cost[i];
            total += remainings[i];
        }
        if (total < 0) return -1;

        int l = 0;
        int r = 0;
        int step = 0;
        int remaining = 0;

        while(l < gas.length) {
            if (step == gas.length) break;
            remaining += remainings[r];
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
        return l;
    }
}
