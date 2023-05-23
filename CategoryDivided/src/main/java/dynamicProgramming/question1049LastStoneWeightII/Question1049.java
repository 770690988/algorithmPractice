package dynamicProgramming.question1049LastStoneWeightII;

import java.util.Arrays;

/**
 * @Author puka
 * @Description 最后一块石头的重量 II
 * @Date 2023/5/22 11:02
 */
public class Question1049 {
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        System.out.println(new Solution().lastStoneWeightII(stones));
    }
}

//讲一下个人的理解，这题要能想到对应的过程其实说白了就是理解好416题，416题目其实是一个模板
//就是对于一些题目需要尽可能拆成对应的两个部分，并且尽可能相等的题目，往往都可以用01背包问题解决

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).parallel().sum();
        int size = sum/2;
        int[] dp = new int[size+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = size; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum  - 2*dp[size];
    }
}
