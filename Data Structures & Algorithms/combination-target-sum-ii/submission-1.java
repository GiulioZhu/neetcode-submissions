class Solution {
    List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, target, new ArrayList<>(), candidates);
        return result;
    }

    public void dfs(int index, int remaining, List<Integer> path, int[] candidates) {
        if (remaining == 0) {

            result.add(new ArrayList<>(path));
            return;
        }

            if (i > index && candidates[i] == candidates[i - 1]) continue;
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > remaining) break;
            if (num > remaining || i == candidates.length) break;

            path.add(num);
            dfs(i+1, remaining - num, path, candidates);


        }

    }
}
