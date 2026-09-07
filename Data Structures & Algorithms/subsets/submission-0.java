class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return results;

    }

    public void dfs(int index, List<Integer> path, int[] nums) {
        results.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i+1, path, nums);
            path.remove(path.size()-1);
        }
    }
}
