package dynamicProgramming.question121MaxProfit;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author puka
 * @Description 买卖股票的最佳时机
 * @Date 2023/5/31 17:25
 */
public class Question121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        Integer length = prices.length;
        int[][] dp = new int[2][length+1];

        dp[0][0] = Integer.MIN_VALUE;

        for (int i = 1; i <= length; i++) {
            dp[0][i] = Math.max(dp[0][i-1],-prices[i-1]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i-1]);
        }
        return dp[1][length];
    }
}