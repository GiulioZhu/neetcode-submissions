class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        int num = chars[0] - 48;
        if (num > 0) dp[0] = 1;
        if (s.length() == 1) return dp[0];

        for (int index = 1; index < s.length(); index++) {
            int curr = chars[index] - 48;
            int prev = chars[index-1] - 48;
            int sum = prev * 10 + curr;
            if (curr > 0 && prev != 0 && sum <= 26) dp[index] = dp[index-1] + 1;
            else if(curr == 0) dp[index] = dp[index-1] - 1;
            else dp[index] = dp[index-1];
        }
        return dp[s.length()-1];
    }
}
