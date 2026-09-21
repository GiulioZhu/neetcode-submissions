class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>());
        return list;
    }

    public void dfs(int index, int[] nums, List<Integer> path, HashMap<Integer) {
        list.add(new ArrayList<>(path));
        
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (i > index && num == nums[i-1]) continue;
            
            path.add(num);
            dfs(i+1, nums, path);
            path.remove(path.size() - 1);
        }
    }
}
