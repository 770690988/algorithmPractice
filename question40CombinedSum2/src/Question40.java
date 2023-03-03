import java.util.*;

public class Question40 {
    public static void main(String[] args){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Solution out = new Solution();
        System.out.println(Arrays.toString(out.combinationSum2(candidates, target).toArray()));
    }
}

//回溯算法+剪枝
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);

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
            if (i > index && candidates[i] == candidates[i - 1]) {//这一步是关键，删除掉后面不需要的部分
                continue;
            }
            methods.add(candidates[i]);
            backTrack(candidates,i+1,methods,target - candidates[i],out);
            methods.removeLast();
        }
    }
}
