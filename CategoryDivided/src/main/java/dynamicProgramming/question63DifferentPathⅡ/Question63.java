package dynamicProgramming.question63DifferentPathⅡ;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/18 11:58
 */
public class Question63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        if (rows == 0){
            return 1;
        }
        int columns = obstacleGrid[0].length;

        int[][] dp = new int[rows][columns];

//        Arrays.fill(dp,0);

        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 0; i < columns; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[rows-1][columns-1];
    }
}