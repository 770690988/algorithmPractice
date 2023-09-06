package greedyAlgorithm.question376WiggleSubsequence;

/**
 * @Author yucl2030
 * @Description 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 * 例如，[1,7,4,9,2,5]是一个摆动序列，因为差值(6,-3,5,-7,3)是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * @Examples 示例 1：
 * <p>
 * 输入：nums = [1,7,4,9,2,5]
 * 输出：6
 * 解释：整个序列均为摆动序列，各元素之间的差值为 (6, -3, 5, -7, 3) 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,17,5,10,13,15,10,5,16,8]
 * 输出：7
 * 解释：这个序列包含几个长度为 7 摆动序列。
 * 其中一个是 [1, 17, 10, 13, 10, 16, 8] ，各元素之间的差值为 (16, -7, 3, -3, 6, -8) 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,6,7,8,9]
 * 输出：2
 * @Date 2023/9/6 9:43
 */
public class Question376 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,5};
        System.out.println(new Solution().wiggleMaxLength(nums));
    }
}

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int temp;
        if (nums[1] - nums[0] > 0){
            temp = 1;
        } else if (nums[1] - nums[0] < 0) {
            temp = -1;
        }else {
            temp = 0;
        }

        int out = Math.abs(temp);
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] - nums[i-1];
            if (cur > 0){
                cur = 1;
            } else if (cur < 0) {
                cur = -1;
            }else {
                cur = 0;
            }
            if ((cur == -temp && cur != 0) || (temp == 0 && cur != 0)){
                out++;
                temp = cur;
            }
        }
        return out + 1;
    }
}