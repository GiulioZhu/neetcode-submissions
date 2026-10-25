class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int l = 0;
        int r = 0;
        int max = nums[0];
        int steps = 0;

        while(l < nums.length && r < nums.length) {
            r = max;
            while (l <= r) {
                if (l + nums[l] > max) max = l + nums[l];
                l++;
            } // ends up at l = r+1
            steps++;
        }
        return steps;
    }
}
