package greedyAlgorithm.question53MaxSubArray;

/**
 * @Author yucl2030
 * @Description question53 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @Examples
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * @Date 2023/9/6 10:28
 */
public class Question53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray2(nums));
    }
}


class Solution{
    //使用贪心算法
    public int maxSubArray(int[] nums) {

        int former = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            former = nums[i] + former;
            max = Math.max(former,max);
            if (former <= 0){
                former = 0;
            }
        }
        return max;
    }

    //使用动态规划  虽然代码更短，但是性能一般般
    public int maxSubArray2(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
