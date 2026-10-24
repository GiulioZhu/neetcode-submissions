class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm
        int global_max = -10001;
        int local_sum = 0;
        for (int num : nums) {
            local_sum = Math.max(num, local_sum+num);
            if (local_sum > global_max) global_max = local_sum;
        }
        return global_max;
    }
}
