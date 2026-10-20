class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        return dfs(0, dp, chars);
    }

    public int dfs(int i, int[] dp, char[] s) {
        if (i == dp.length) return dp[i-1]; // base case
        if (s[i] == '0') return 0; // base not case

        int res = dfs(i+1, dp, s);
        if(i + 1 < dp.length && (s[i] == '1' || (s[i] == '2' && s[i+1] - 48 <= 6)))
            res += dfs(i+2, dp, s);
        dp[i] = res;
        return res;
    }
}
