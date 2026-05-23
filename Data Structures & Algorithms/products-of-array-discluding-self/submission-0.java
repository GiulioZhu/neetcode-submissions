class Solution {
    public int[] productExceptSelf(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i+1; j < nums.length; j++) {
                product *= nums[j];
            }
            map.put(i, product);
        }

        for (int i = 1; i < nums.length; i++) {
            int product = map.get(i);
            for (int j = i-1; j >= 0; j--) {
                product *= nums[j];
            }
            map.put(i, product);
        }

        map.forEach((index, value) -> ans[index] = value);
        return ans;     
    }
}  
