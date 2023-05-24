package dynamicProgramming.question279NumSquares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author puka
 * @Description 完全平方数
 * @Date 2023/5/24 11:33
 */
public class Question279 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution().numSquares(n));
    }
}

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        Integer square = 0;
        int num = 0;
        while (square < n){
            num++;
            square = num*num;
            squares.add(square);
        }

        int[] dp = new int[n+1];
        //dp初始化
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0; i < squares.size(); i++) {
            for (int j = squares.get(i); j <= n; j++) {
                dp[j] = Math.min(dp[j],dp[j-squares.get(i)]+1);
            }
        }
        return dp[n];
    }
}
