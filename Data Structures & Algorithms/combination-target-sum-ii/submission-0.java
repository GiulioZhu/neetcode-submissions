class Solution {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<HashMap<Integer, Integer>> set = new HashSet<>();
    

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, new ArrayList<>(), candidates);
        return result;
    }

    public void dfs(int index, int remaining, List<Integer> path, int[] candidates) {
        if (remaining == 0) {
            HashMap<Integer, Integer> map = buildMap(path);
            if (set.contains(map)) return;
            set.add(map);
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            
            if (num > remaining || i == candidates.length) break;

            path.add(num);
            dfs(i+1, remaining - num, path, candidates);
            path.remove(path.size() - 1);
        }
    }

    public HashMap<Integer, Integer> buildMap(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int ele : list) {
            if (!map.containsKey(ele)) map.put(ele, 1);
            else map.put(ele, map.get(ele) + 1);
        }
        return map;
    }
}
