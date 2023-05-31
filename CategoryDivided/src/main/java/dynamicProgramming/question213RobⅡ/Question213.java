package dynamicProgramming.question213RobⅡ;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 打家劫舍 II
 * @Date 2023/5/25 11:16
 */
public class Question213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println(new Solution().rob(nums));
    }
}

class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1){
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        return Math.max(robSingle(Arrays.copyOfRange(nums,0,nums.length-1)),robSingle(Arrays.copyOfRange(nums,1,nums.length)));

    }

    int robSingle(int[] nums){
        int[] dp = new int[nums.length+1];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            //表示上一家打劫过了
            if (dp[i-1] > dp[i-2]){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            }else {
                dp[i] = dp[i-1]+nums[i-1];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }
}