class Solution {

    /* bottom-up
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }
    */

    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dp(nums, 0);
    }

    public int dp(int[] nums, int index) {
        if (index >= nums.length) return 0;

        if (memo[index] != -1) {
            return memo[index];
        }

        memo[index] = Math.max(nums[index] + dp(nums, index+2), dp(nums, index+1));

        return memo[index];
    }
    
}
