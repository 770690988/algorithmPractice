import java.util.*;

public class Question103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode2_1 = new TreeNode(2);
        TreeNode treeNode2_2 = new TreeNode(3);
        treeNode2_1.left = new TreeNode(4);
        treeNode2_2.right = new TreeNode(5);
        root.left = treeNode2_1;
        root.right = treeNode2_2;
        List<List<Integer>> lists = new Solution().zigzagLevelOrder(root);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null){
            return out;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        Integer flag = 1;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Integer num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (flag != 1){
                Collections.reverse(list);
            }
            out.add(list);
            flag *= -1;
        }
        return out;
    }
}