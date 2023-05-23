package dynamicProgramming.question416DivideEqualSumSubsets;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 分割等和子集
 * @Date 2023/5/22 10:43
 */
public class Question416 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new Solution().canPartition(nums));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        //如果总和为奇数直接返回
        if (sum % 2 == 1){
            return false;
        }

        //否则就取总重量的一半作为背包的容量
        Integer size = sum / 2;

        //这里的dpi表示的是i容量的背包能容纳的最大价值
        int[] dp = new int[size+1];

        //初始化dp

        //动态转移方程 i 表示容量，j表示第j个物体
        // dp[i] = Math.max(dp[i],dp[i-nums[j]]+nums[j]);
        //这里ij交换一下
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }

        return dp[size] == size;
    }
}