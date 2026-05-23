class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> history = new Stack<>();
        int[] ans = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int[] entry = new int[2];
            entry[0] = temperatures[i]; entry[1] = i;
            if (history.isEmpty()) {
                history.push(entry);
                continue;
            }

            if (temperatures[i] > history.peek()[0]) {
                while(!history.isEmpty() && temperatures[i] > history.peek()[0]) {
                    int[] tmp = history.pop();
                    ans[tmp[1]] = i - tmp[1];
                }
            }
            history.push(entry);
        }
        return ans;
    }
}
