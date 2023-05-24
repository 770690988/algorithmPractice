package dynamicProgramming.question474FindMaxForm;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 一和零
 * @Date 2023/5/23 10:38
 */
public class Question474 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(new Solution().findMaxForm(strs,m,n));
    }
}

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        //dp的初始化操作


        //dp的递推公式dp[i][j] =
        for (String str : strs) {
            int[] weight = countNums(str);
            for (int i = m; i >= weight[0] ; i--) {
                for (int j = n; j >= weight[1] ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-weight[0]][j-weight[1]]+1);
                }
            }
        }
        return dp[m][n];
    }
    int[] countNums(String str){
        int[] out = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1'){
                out[1]++;
            }
            if (str.charAt(i) == '0'){
                out[0]++;
            }
        }
        return out;
    }
}
