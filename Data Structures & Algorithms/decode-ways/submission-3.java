class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        dp.put(s.length(), 1);
        return dfs(0, dp, chars);
    }

    public int dfs(int i, HashMap<Integer, Integer> dp, char[] s) {
        if (dp.containsKey(i)) return dp.get(i); // base case
        if (s[i] == '0') return 0; // base not case

        int res = dfs(i+1, dp, s);
        if(i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i+1] <= '6')))
            res += dfs(i+2, dp, s);
        dp.put(i, res);
        return res;
    }
}
