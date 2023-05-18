package dynamicProgramming.question62DifferentPath;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 不同路径
 * @Date 2023/5/18 11:30
 */
public class Question62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(new Solution().uniquePaths(m,n));
    }
}

/**
 * 这题思路也不算很难 也就是依次往右下进行补充计算完放入表格里面依次递推即可
 */

class Solution {

    //使用动态规划来解题
    public int uniquePaths(int m, int n) {
        //特殊情况判断也就是只有一行一列的位置的处理
        if (m == 1 && n == 1){
            return 1;
        }
        //先确定dp 这里的dp表示从右上角到对应的m行n列的路径之和
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        //递推公式 dp[m][n] = dp[m-1][n] + dp[m][n-1]也就是当前位置的路径数量等于左边一格的数量加上上方一格的数量
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}