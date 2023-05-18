package dynamicProgramming.question746UseMinimumCostClimbStairs;

/**
 * @Author puka
 * @Description 使用最小花费爬楼梯
 * @Date 2023/5/18 10:22
 */
public class Question746 {
    public static void main(String[] args) {
        int[] cost = {10,15,20};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}

/**
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length < 2) return 0;
        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[length-1];
    }
}