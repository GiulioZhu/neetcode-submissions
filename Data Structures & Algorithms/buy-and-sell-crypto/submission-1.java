class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = 0;

        while (j < prices.length) {
            int profit = prices[j] - prices[i];
            if (profit > max) max = profit;


            if (prices[i] > prices[j]) {
                i = j;
                j = i+1;
            } else j++;
        }
        return max;
    }
}
