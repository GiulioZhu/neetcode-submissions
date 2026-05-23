class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i-1] == nums[i]) continue;
            List<Integer> sublist = new ArrayList<>();
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) right--;
                else if (sum < 0) left++;
                else {
                    sublist.add(nums[i]); sublist.add(nums[left]); sublist.add(nums[right]); 
                    if (!ans.contains(sublist)) ans.add(sublist); 
                    sublist = new ArrayList<>();
                    left++;
                }
            }
        }

        return ans;
    }
}
