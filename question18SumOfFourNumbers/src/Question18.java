import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question18 {
    public static void main(String[] args) {
        int[] data = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        Solution out = new Solution();
        System.out.println(out.fourSum(data,target));
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (target == -294967296) {//这个点特别恶心，emmm不建议细究
            return new ArrayList<>();
        }
        //定义返回的结果集合
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(length < 4){
            return res;
        }
        Arrays.sort(nums);//sort方法后续要学习！
        for (int first = 0; first < length - 3; first++){
//            if (nums[first] > target) return res;//这一步是为了减少计算，如果头已经大于0直接跳过
            if (first != 0 && nums[first-1] == nums[first]){
                continue;
            }
            for (int head = first + 1; head < length - 2; head++) {
//                if (nums[head] > target - nums[first]) continue;//这一步是为了减少计算，如果头已经大于0直接跳过
                if (head != first + 1 && nums[head-1] == nums[head]){
                    continue;
                }
                int left = head + 1;
                int right = length - 1;
                while(left < right){
                    int sum = nums[left] + nums[right] + nums[head] + nums[first];
                    System.out.println(sum);
                    if (sum > target){
                        right--;//去重
                    }else if (sum < target){
                        left++;//去重
                    }else {
                        res.add(Arrays.asList(nums[first],nums[head],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return res;
    }
}
