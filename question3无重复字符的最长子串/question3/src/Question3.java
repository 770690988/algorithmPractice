import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Question3 {
    public static void main(String[] args) {
        String s = "a";
        Solution solution = new Solution();
        int out = solution.lengthOfLongestSubstring2(s);
        System.out.println(out);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * 从头开始新遍历，遇到一样的则调回上一个节点的下一个 value存的是第几个位置，但时间复杂度过高
         * 优化思路，遇到相同的之后不进行遍历，转而采用计算的方式完成
         */
        int out = 0;
        int count = 0;
        int atValue = 0;
        StringBuffer sb = new StringBuffer(s);
        HashMap<Integer,Integer> recordList = new HashMap<>();
        for (int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            int data = String.valueOf(c).hashCode();
            if (recordList.containsKey(data)){
                if (count > out){
                    out = count;
                }
                i -= atValue - recordList.get(data)+1;
                recordList.remove(data);
                atValue++;
                count = 0;
            }else {
                atValue++;
                recordList.put(data,atValue);
                count++;

            }
        }
        if (count > out){
            out = count;
        }
        return out;
    }

    public int lengthOfLongestSubstring2(String s) {
        /**
         * 优化思路1 采用滑动窗口方式
         */
        if(s.length() == 0)return 0;
        // StringBuffer sb = new StringBuffer(s);
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int out = 0;
        for (int i = 0; i < s.length(); i++) {
            char data = s.charAt(i);
            if (map.containsKey(data)){
                left = Math.max(left,map.get(data)+1);
            }
            map.put(data,i);
            out = Math.max(i-left+1, out);
        }
        return out;
    }
}
