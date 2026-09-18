class Solution {
    List<List<Integer>> results = new ArrayList<>();
    List<HashMap<Integer, Integer>> map = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(new ArrayList<>(), nums, target);
        return results;
    }

    public void dfs(List<Integer> path, int[] nums, int target) {
        if (sumArr(path) == target) {
            if (unique(path)) results.add(new ArrayList<>(path));   
            return;
        } else if (sumArr(path) > target) return;

        for (int num : nums) {
            path.add(num);
            dfs(path, nums, target);
            path.remove(path.size() - 1);
        }

    }

    public int sumArr(List<Integer> arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    public boolean unique(List<Integer> arr) {
        HashMap<Integer, Integer> combination = new HashMap<>();
        for (int i : arr) {
            if (!combination.containsKey(i)) combination.put(i, 1);
            else combination.put(i, combination.get(i) + 1);
        }

        if (map.contains(combination)) return false;
        map.add(combination);
        return true;
    }
}
