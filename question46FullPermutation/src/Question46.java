import java.util.*;

public class Question46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> out = new Solution().permute(nums);
        System.out.println(Arrays.toString(out.toArray()));
    }
}

class Solution {
    public Integer numLength;
    public List<Integer> arrangement = new ArrayList<>();
    List<List<Integer>> out = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        numLength = nums.length;

        List<Integer> unUsed = new ArrayList<>();
        //添加元素到列表中
        for (int i = 0; i < numLength; i++) {
            unUsed.add(nums[i]);
        }
        dfs(0,unUsed);
        return out;
    }

    private void dfs(Integer position, List<Integer> unUsed){
        if (position == numLength){
            out.add(new ArrayList<>(arrangement));
            return;
        }
        for (Integer num : unUsed) {
            arrangement.add(num);
            ArrayList<Integer> unUsedList = new ArrayList<>(unUsed);
            unUsedList.removeIf(next -> next.equals(num));
            dfs(position+1,unUsedList);
            arrangement.remove(arrangement.size()-1);
        }
    }
}