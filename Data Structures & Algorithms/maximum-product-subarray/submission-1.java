class Solution {
    public int maxProduct(int[] nums) {
        int g_max = -11;
        if (nums.length == 1) return nums[0];
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];

        dp_max[0] = nums[0]; dp_min[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max = Math.max(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]);
            int min = Math.min(dp_max[i-1] * nums[i], dp_min[i-1] * nums[i]);
            dp_max[i] = Math.max(max, nums[i]);
            dp_min[i] = Math.min(min, nums[i]);
            g_max = Math.max(dp_max[i], g_max);
        }

        return g_max;
    }
}
