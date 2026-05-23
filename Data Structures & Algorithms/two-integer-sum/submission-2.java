class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        int complement;
        for (int i = 0; i < nums.length; i++) {
            numbers.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            complement = target - nums[j];
            if (numbers.containsKey(complement) && numbers.get(complement) != j) {
                return new int[]{j, numbers.get(complement)};
            }
        }

        return new int[]{};
    }
}
