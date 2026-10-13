class Solution {
    public int rob(int[] nums) {
        return dp(0, nums);
    }

    public int dp(int index, int[] nums) {
        if (index >= nums.length) return 0;
        return Math.max(nums[index] + dp(index+2, nums), dp(index+1, nums));
    }
}
