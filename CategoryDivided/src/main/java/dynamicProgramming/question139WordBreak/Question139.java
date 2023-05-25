package dynamicProgramming.question139WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author puka
 * @Description 单词拆分
 * @Date 2023/5/25 10:12
 */
public class Question139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict= Arrays.asList("leet", "code");
        System.out.println(new Solution().wordBreak(s,wordDict));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        //dp初始化
        dp[0] = true;
        
        //dp递推公式
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (i >= wordDict.get(j).length()){
                    dp[i] = dp[i] || (dp[i-wordDict.get(j).length()] && wordDict.get(j).equals(s.substring(i-wordDict.get(j).length(),i)));
                }
            }
        }
        return dp[s.length()];
    }

}
