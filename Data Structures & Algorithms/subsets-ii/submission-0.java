class Solution {
    List<List<Integer>> list = new ArrayList<>();
    HashMap<Integer, Integer> tracker = new HashMap<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for (int num: nums) {
            if (!tracker.containsKey(num)) tracker.put(num, 1);
            else tracker.put(num, tracker.get(num) + 1);
        }
        dfs(0, nums, new ArrayList<>(), new HashMap<>());
        return list;
    }

    public void dfs(int index, int[] nums, List<Integer> path, HashMap<Integer, Integer> map) {
        if (!list.contains(path)) list.add(new ArrayList<>(path));
        

        for (int i = index; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && map.get(num) > tracker.get(num)) continue;

            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
            
            path.add(num);
            dfs(index+1, nums, path, map);
            path.remove(path.size() - 1);
        }
    }
}
