class Solution {
    List<List<Integer>> results = new ArrayList<>();
    

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0, target, new ArrayList<>(), nums, target);
        return results;
    }

    public void dfs(int index, int remaining, List<Integer> path, int[] nums, int target) {
        if (remaining == 0) {
            results.add(new ArrayList<>(path));   
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];

            if (num > remaining) break;

            path.add(num);
            dfs(i, remaining - num, path, nums, target);
            path.remove(path.size() - 1);
        }

    }
}
