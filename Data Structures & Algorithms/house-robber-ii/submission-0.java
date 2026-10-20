class Solution {
    public int rob(int[] nums) {
        int[] nums2 = new int[nums.length];
        nums2[0] = nums[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            nums2[i] = nums[i-1];
        }

        return Math.max(tryrob(nums), tryrob(nums2));
    }

    public int tryrob (int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < nums.length-1; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length-2];
    }
}
