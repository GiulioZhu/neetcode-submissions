class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(0, memo, nums);
    }

    public int dp(int index, int[] memo, int[] nums) {
        if (index >= nums.length) return 0;
        int skip = dp(index+1, memo, nums);
        int rob = nums[index] + dp(index+2, memo, nums);
        if (memo[index] != -1) return memo[index];
        memo[index] = Math.max(rob, skip);
        return memo[index];
    }
}
