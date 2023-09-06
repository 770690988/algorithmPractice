package dynamicProgramming.question123MaxProfitⅢ;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 买卖股票的最佳时机 III
 * @Date 2023/6/1 16:13
 */
public class Question123 {
    public static void main(String[] args) {
        int[] prices = {6,1,3,2,4,7};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[5][length+1];
        if (length <= 1){
            return 0;
        }
        dp[3][1] = dp[1][1] = -prices[0];
        for (int i = 2; i <= length ; i++) {
            dp[1][i] = Math.max(dp[1][i-1], -prices[i-1]);
            dp[2][i] = Math.max(dp[2][i-1], dp[1][i-1] + prices[i-1]);
            dp[3][i] = Math.max(dp[3][i-1], dp[2][i-1] - prices[i-1]);
            dp[4][i] = Math.max(dp[4][i-1], dp[3][i-1] + prices[i-1]);
        }
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        System.out.println(Arrays.toString(dp[4]));
        return dp[4][length];
    }
}