/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/17 17:07
 */
public class Question53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution2().maxSubArray(nums));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        //最大的和
        Integer restMax = nums[0];
        //当前和
        Integer restSum = nums[0];
        //之前和
        Integer formerSum = null;

        for (int i = 1; i < nums.length; i++) {
            formerSum = restSum;
            if (formerSum > 0){
                restSum = formerSum+nums[i];
            }else {
                restSum = nums[i];
            }
            restMax = Math.max(restMax, restSum);
        }

        return restMax;
    }
}

class Solution2 {
    public int maxSubArray(int[] nums) {
        int former = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (former>=0){
                nums[i] = nums[i] + former;
                former = nums[i];
            }else {
                former = nums[i];
            }
            max = Math.max(nums[i],max);
        }
        return max;
    }
}

