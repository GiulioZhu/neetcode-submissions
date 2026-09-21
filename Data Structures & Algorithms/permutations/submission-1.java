class Solution {
    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0, new ArrayList<>(), nums);
        return results;
    }

    public void dfs(int index, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (path.contains(num)) continue;
            path.add(num);
            dfs(i, path, nums);
            path.remove(path.size() - 1);
        }
    }

}
