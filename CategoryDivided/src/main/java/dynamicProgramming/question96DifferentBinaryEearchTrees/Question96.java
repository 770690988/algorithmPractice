package dynamicProgramming.question96DifferentBinaryEearchTrees;

/**
 * @Author puka
 * @Description 不同的二叉搜索树
 * @Date 2023/5/19 10:15
 */
public class Question96 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().numTrees(n));
    }
}

class Solution {
    public int numTrees(int n) {
        // 确定dp数组的含义，dpi表示的是i个节点形成的二叉搜索树可以有的种数
        int[] dp = new int[n+1];
        if (n <= 2){
            return 1;
        }
        //初始化,记得修改循环
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        //开始递推
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
