package dynamicProgramming.question188MaxProfitⅣ;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 买卖股票的最佳时机 IV
 * @Date 2023/6/1 16:50
 */
public class Question188 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 3;
        System.out.println(new Solution().maxProfit(k,prices));
    }
}

class Solution {
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        if (length <= 1){
            return 0;
        }
        int[][] dp = new int[2*k][length+1];

        for (int i = 0; i < k; i++) {
            dp[i*2][1] = -prices[0];
        }

        for (int i = 2; i <= length; i++) {
            dp[0][i] = Math.max(dp[0][i-1], -prices[i-1]);
            dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + prices[i-1]);
            for (int j = 1; j < k; j++) {
                dp[2*j][i] = Math.max(dp[2*j][i-1], dp[2*j-1][i-1] - prices[i-1]);
                dp[2*j+1][i] = Math.max(dp[2*j+1][i-1], dp[2*j][i-1] + prices[i-1]);
            }
        }
        System.out.println(Arrays.toString(dp[0]));
        System.out.println(Arrays.toString(dp[1]));
        System.out.println(Arrays.toString(dp[2]));
        System.out.println(Arrays.toString(dp[3]));
        return dp[2*k-1][length];
    }
}