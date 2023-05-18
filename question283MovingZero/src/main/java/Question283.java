import java.util.Arrays;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/16 10:07
 */
public class Question283 {
    public static void main(String[] args) {
        int[] nums = {0,0,1};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail){
            if (nums[head] == 0 && nums[tail] != 0){
                int count = tail;
                for (int i = head; i < count; i++) {
                    nums[i] = nums[i+1];
                }
                nums[tail] = 0;
                tail--;
            }else if (nums[head] != 0){
                head++;
            }else {
                tail--;
            }
        }
    }
}