class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), new HashMap<>());
        return list;
    }

    public void dfs(int index, int[] nums, List<Integer> path, HashMap<Integer, Integer> map) {
        list.add(new ArrayList<>(path));
        
        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (i > index && num == nums[i-1]) continue;
            
            path.add(num);
            dfs(i+1, nums, path, map);
            path.remove(path.size() - 1);
        }
    }
}
