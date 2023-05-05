import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question77 {
    public static void main(String[] args) {
        Integer number = 9;
        Integer keyNum = 2;
        System.out.println(Arrays.toString(new Solution().combine(number, keyNum).toArray()));

    }
}


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] dataList = new int[n];
        for (int i = 0; i < n; i++) {
            dataList[i] = i+1;
        }

        backtrace(dataList, 0, ans, new ArrayList<>(), k);
        return ans;
    }

    void backtrace(int[] dataList, Integer index, List<List<Integer>> ans, List<Integer> list, Integer k){
        if (dataList.length - index - 1 + list.size() <= k){
            return;
        }
        //个数够了
        if (k.equals(list.size())){
            ans.add(new ArrayList<>(list));
            return;
        }
        //到列表末尾了
        if (index.equals(dataList.length)){
            return;
        }

        for (int i = index; i < dataList.length; i++) {
            list.add(dataList[i]);
            backtrace(dataList,i+1,ans,list,k);
            list.remove(list.size()-1);
        }
    }
}