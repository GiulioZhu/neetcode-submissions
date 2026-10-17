class Solution {
    int min = Integer.MAX_VALUE;
    List<List<Integer>> sack = new ArrayList<>(); 

    /*
    coins[0]
    coins[0]
    */

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        dp(coins, amount);
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    public void dp(int[] coins, int amount) {

    }

}
