package dynamicProgramming.question122MaxProfitⅡ;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 买卖股票的最佳时机 II
 * @Date 2023/5/31 19:28
 */
public class Question122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[2][length+1];
        if (length < 2){
            return 0;
        }
        dp[0][1] = -prices[0];

        for (int i = 2; i <= length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],dp[1][i-1] - prices[i-1]);
            dp[1][i] = Math.max(dp[1][i-1],dp[0][i-1] + prices[i-1]);
        }
        return dp[1][length];
    }
}