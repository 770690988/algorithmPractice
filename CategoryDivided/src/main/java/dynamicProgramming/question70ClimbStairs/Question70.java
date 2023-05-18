package dynamicProgramming.question70ClimbStairs;

/**
 * @Author puka
 * @Description 爬楼梯
 * @Date 2023/5/18 10:12
 */
public class Question70 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().climbStairs(n));
    }
}

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if (n <= 2) return n;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}