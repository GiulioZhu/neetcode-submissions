class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        int max_jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max_jump) return false;
            dp[i] = i + nums[i]; // max
            if (dp[i] > max_jump) max_jump = dp[i];
        }
        return true;
    }
}
