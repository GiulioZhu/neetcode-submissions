class Solution {

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        int[] mins = new int[amount+1];
        Arrays.fill(mins, Integer.MAX_VALUE - 1);
        mins[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i < mins.length; i++) {
                mins[i] = Math.min(mins[i], mins[i-coin] + 1);
            }
        }

        if (mins[amount] == Integer.MAX_VALUE - 1) return -1;
        return mins[amount];
    }

}
