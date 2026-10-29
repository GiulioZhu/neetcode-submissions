class Solution {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length == 1) return ans;
        
        for (int i = 1; i < nums.length; i++) ans ^= nums[i];
        return ans;
    }
}
