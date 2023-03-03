import java.util.*;

public class Question39 {
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution out = new Solution();
//        List<Integer> data1 = new ArrayList<>();
//        data1.add(2);
//        List<List<Integer>> dataSum = new ArrayList<>();
//        dataSum.add(data1);
//        System.out.println(Arrays.toString(dataSum.toArray()));
        System.out.println(Arrays.toString(out.combinationSum(candidates, target).toArray()));
    }
}

/**
 * question
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合
 *
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> out = new ArrayList<>();
        Deque<Integer> methods = new ArrayDeque<>();
        backTrack(candidates,0,methods,target,out);
        return out;
    }

    public void backTrack(int[] candidates, int index, Deque<Integer> methods, int target, List<List<Integer>> out){
        if (target < 0){
            return;
        }
        if(target == 0){
            out.add(new ArrayList<>(methods));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            methods.add(candidates[i]);
            backTrack(candidates,i,methods,target - candidates[i],out);
            methods.removeLast();
        }
    }
}
