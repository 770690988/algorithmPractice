package dynamicProgramming.question343IntegerSplitting;

/**
 * @Author puka
 * @Description 整数拆分
 * @Date 2023/5/19 10:02
 */
public class Question343 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution().integerBreak(n));
    }

}

class Solution {
    public int integerBreak(int n) {
        if (n == 2){
            return 1;
        }
        int[] dp = new int[n+1];
        //初值的赋值
        dp[2] = 1;

        //递推公式
        for (int i = 3; i <= n ; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
//            System.out.println(i+":"+dp[i]);
        }

        return dp[n];
    }
}
