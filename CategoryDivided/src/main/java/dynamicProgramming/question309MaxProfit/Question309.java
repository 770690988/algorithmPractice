package dynamicProgramming.question309MaxProfit;

/**
 * @Author puka
 * @Description 最佳买卖股票时机含冷冻期
 * @Date 2023/6/1 17:09
 */
public class Question309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        //0表示当前持有
        //1表示当前不持有
        //2表示当前在冷冻期
        int[][] dp = new int[4][length+1];
        if (length < 2){
            return 0;
        }
        dp[0][1] = -prices[0];

        for (int i = 2; i <= length; i++) {
//            dp[0][i] = Math.max(dp[0][i-1], dp[2][i-1] - prices[i-1],dp[]);
//            dp[1][i] = Math.max(dp[0][i-1], );
        }
        return dp[1][length];
    }
}