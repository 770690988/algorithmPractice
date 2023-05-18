import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author puka
 * @Description TODO
 * @Date 2023/5/16 9:46
 */
public class Question128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int out = new Solution().longestConsecutive(nums);
        System.out.println(out);
    }

}

class Solution {
    public int longestConsecutive(int[] nums) {
        Integer longestLen = 0;
        Integer nowLen = 0;
        HashSet<Integer> set =  new HashSet<>();
        //先遍历一编把所有的nums都放到hashset中
        for (Integer num : nums) {
            set.add(num);
        }
        for (Integer number : set) {
            Integer data = number;
            //判断当前这个数是不是分段中最小的
            if (!set.contains(data - 1)) {
                //这里表明是最小的，那么就还是循环找，看看比这个大的依次有多少
                while (set.contains(data)) {
                    nowLen++;
                    data++;
                }
                if (nowLen > longestLen) {
                    longestLen = nowLen;
                }
                nowLen = 0;
            }
        }
        return longestLen;
    }
}