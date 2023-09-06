package dynamicProgramming.question509FibonacciNumber;

/**
 * 这题是一道很简单的题目，这题目的意义就在于 理解和认识到按照动规五部曲是如何解题的。并且学习这个方法
 */

/**
 * @Author puka
 * @Description 斐波那契数
 * @Date 2023/5/18 9:56
 */

public class Question509 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().fib(n));
    }
}

class Solution {
    public int fib(int n) {
        if (n < 2) return n;
        //这个就是dp数组 dp[i] 表示的是第i个斐波那契额数的值
        int[] dp = new int[n+1];
        //这里是dp的初始化 这一步要在下面的动态转移方程出来之后进行填写
        dp[0] = 0;
        dp[1] = 1;
        //动态转移方程就是 dp[n] = dp[n-1] + dp[n-2]
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}