class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] < min) min = nums[mid];
            if (nums[left] < min) min = nums[left];
            if (nums[mid] >= nums[left]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return min;
    }
}
