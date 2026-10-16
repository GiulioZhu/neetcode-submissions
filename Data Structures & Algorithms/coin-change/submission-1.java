class Solution {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        dfs(0, 0, coins, amount);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void dfs(int count, int path, int[] coins, int amount) {
        if (path == amount) {
            if (count > 0 || count < min) min = count;
            return;
        }
        if (coins[0] > amount - path) return;

        for (int coin : coins) {
            path += coin;
            count++;
            dfs(count, path, coins, amount);
            path -= coin;
            count--;
        }
    }

}
