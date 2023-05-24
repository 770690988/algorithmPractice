package dynamicProgramming.question322Change;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 零钱兑换
 * @Date 2023/5/24 11:25
 */
public class Question322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new Solution().coinChange(coins,amount));
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE-1){
            return -1;
        }
        return dp[amount];
    }
}