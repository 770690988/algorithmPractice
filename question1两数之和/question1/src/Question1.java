import java.util.ArrayList;
import java.util.HashMap;

public class Question1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,1};
        int target = 9;
        Solution solution = new Solution();
        int[] out = solution.twoSum1(nums, target);
        System.out.println("["+nums[0]+","+nums[1]+"]");
    }
}

/**
 * question:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public  int[] twoSum(int[] nums, int target){
        /*
        The easiest way is a violent way time complexity of O (N^2)
         */
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        //这里的方式采用剩余的数，放入hashMap中，在便利的时候如果存在直接可以获取最终答案。
        int[] indexs = new int[2];
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }
}


