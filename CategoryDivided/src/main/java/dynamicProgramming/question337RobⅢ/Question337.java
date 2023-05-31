package dynamicProgramming.question337RobⅢ;

/**
 * @Author puka
 * @Description 打家劫舍 III
 * @Date 2023/5/25 11:57
 */
public class Question337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.println(new Solution().rob(root));
    }
}

class Solution {
    public int rob(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0],result[1]);
    }

    public int[] robTree(TreeNode node){
        int[] dp = new int[2];
        if (node == null){
            return dp;
        }
        int[] left = robTree(node.left);
        int[] right = robTree(node.right);
        //偷当前位置
        dp[0] = node.val + left[1] + right[1];
        //不偷当前的位置
        dp[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return dp;
    }
}