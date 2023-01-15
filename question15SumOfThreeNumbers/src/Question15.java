import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question15 {
    public static void main(String[] args) {
        int[] data = {-1,0,1,2,-1,-4};
        Solution out = new Solution();
        System.out.println(out.threeSum(data));
    }
}

/**
 * question
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //定义返回的结果集合
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(nums == null || length < 3){
            return res;
        }
        Arrays.sort(nums);//sort方法后续要学习！
//        System.out.print("排序后的数组为");
//        for (int i = 0; i < length; i++) {
//            System.out.print(nums[i]+" ");
//        }
//        System.out.println();
        for (int head = 0; head < length - 2; head++) {
            if (nums[head] > 0) return res;//这一步是为了减少计算，如果头已经大于0直接跳过
            if (head != 0 && nums[head-1] == nums[head]){
                continue;
            }
            int left = head + 1;
            int right = length - 1;
            while(left < right){
                int sum = nums[left] + nums[right] + nums[head];
                if (sum > 0){
                    right--;//去重
                }else if (sum < 0){
                    left++;//去重
                }else {
                    res.add(Arrays.asList(nums[head],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        return res;
    }
}