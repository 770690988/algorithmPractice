public class Question101 {

}

/**
 * https://leetcode.cn/problems/symmetric-tree/description/
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode nodeLeft = root.left;
        TreeNode nodeRight = root.right;
        return isMirror(nodeLeft,nodeRight);
    }

    private boolean isMirror(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null){
            return true;
        }
        if (nodeLeft == null || nodeRight == null){
            return false;
        }
        boolean flag = nodeLeft.val == nodeRight.val;
        return flag && isMirror(nodeLeft.left,nodeRight.right) && isMirror(nodeLeft.right,nodeRight.left);
    }
}