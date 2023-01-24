import java.util.Arrays;

public class Question34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Solution out = new Solution();
        System.out.println(Arrays.toString(out.searchRange(nums, target)));
    }
}

/**
 *
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] out = {-1,-1};
        int lenth = nums.length;
        if (lenth == 0){
            return out;
        }

        int first = findFirstPostition(nums,target);
        if (first == -1){
            return out;
        }
        out[0] = first;
        int last = findLastPostition(nums,target);
        out[1] = last;
        return out;
    }

    private int findFirstPostition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            }else {
                right = mid - 1;
            }
        }
        if (nums[left] == target){
            return left;
        }
        return -1;
    }

    private int findLastPostition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right + 1) >>> 1;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        if (nums[right] == target){
            return right;
        }
        return -1;
    }
}
