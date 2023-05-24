package dynamicProgramming.question494FindTargetSumWays;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 目标和
 * @Date 2023/5/23 9:38
 */
public class Question494 {
    public static void main(String[] args) {
        int[] nums = {100};
        int target = -200;
        System.out.println(new Solution().findTargetSumWays(nums,target));
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int bagWeightDouble = sum + target;
        if (bagWeightDouble % 2 == 1 || bagWeightDouble < 0){
            return 0;
        }
        int bagWeight = bagWeightDouble/2;

        //dpi数组表示的是在i容量的背包里面塞满有集中方式
        int[] dp = new int[bagWeight+1];

        //dp初始化
        dp[0] = 1;

        //dp递推
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagWeight; j >= nums[i] ; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[bagWeight];
    }
}