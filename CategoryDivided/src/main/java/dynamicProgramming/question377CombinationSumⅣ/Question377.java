package dynamicProgramming.question377CombinationSumⅣ;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 组合总和 Ⅳ
 * @Date 2023/5/24 11:01
 */
public class Question377 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(new Solution().combinationSum4(nums,target));
    }
}

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];

        dp[0] = 1;


        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]){
                    dp[j] += dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}