package dynamicProgramming.question198Rob;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 打家劫舍
 * @Date 2023/5/25 11:00
 */
public class Question198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new Solution().rob(nums));
    }
}

class Solution {
    public int rob(int[] nums) {
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