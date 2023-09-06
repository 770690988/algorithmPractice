package dynamicProgramming.question518ChangeⅡ;

/**
 * @Author puka
 * @Description 零钱兑换 II
 * @Date 2023/5/24 10:31
 */
public class Question518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(new Solution().change(amount,coins));
    }
}

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        //dp初始化
        dp[0] = 1;

        //dp递推  dp[i] += dp[i-coins[n]+1
        for (int n = 0; n < coins.length; n++) {
            for (int i = coins[n]; i <= amount; i++) {
                dp[i] += dp[i-coins[n]];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        //dp初始化
        dp[0] = 1;

        //dp递推  dp[i] += dp[i-coins[n]+1
        for (int n = 0; n < coins.length; n++) {
            for (int i = coins[n]; i <= amount; i++) {
                dp[i] += dp[i-coins[n]];
            }
        }
        return dp[amount];
    }
}
