import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public static void main(String[] args) {
        int number = 3;
        Solution out = new Solution();
        System.out.println(out.generateParenthesis(number));
    }
}

/**
 * question
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        backtrack(out,new StringBuilder(),0,0,n);
        return out;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max*2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max){
            cur.append("(");
            backtrack(ans,cur,open+1,close,max);
            cur.deleteCharAt(cur.length()-1);
        }
        if (close < open){
            cur.append(")");
            backtrack(ans,cur,open,close+1,max);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}