import java.util.Arrays;

public class Question33 {
    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 1;
        Solution out = new Solution();
        System.out.println(out.search(nums, target));
    }
}

/**
 * question
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */

class Solution {
    public int search(int[] nums, int target) {
        int first = 0;
        int end = nums.length - 1;
        return QuickSortHalf(nums,first,end,target);
    }

    public int QuickSortHalf(int[] nums, int first,int end, int target){
        if (first > end){
            return -1;
        }
        if (first == end && nums[first] != target) return -1;
        int index = (first + end) / 2;
        if (nums[first] <= nums[index]){
            if (target >= nums[first] && target <= nums[index]){
                //说明答案在这里面
                int i = (first + index) / 2;
                if (target == nums[i]){
                    return i;
                }if (target > nums[i]){
                    return QuickSortHalf(nums,i+1,index,target);
                }else {
                    return QuickSortHalf(nums,first,i,target);
                }
            }else{
                return QuickSortHalf(nums,index+1,end,target);
            }
        }else{
            if (target >= nums[index] && target <= nums[end]){
                //说明答案在这里面
                int i = (end + index) / 2;
                if (target == nums[i]){
                    return i;
                }if (target > nums[i]){
                    return QuickSortHalf(nums,i+1,end,target);
                }else {
                    return QuickSortHalf(nums,index,i,target);
                }
            }
        }
        return QuickSortHalf(nums,first,index,target);
    }
}
