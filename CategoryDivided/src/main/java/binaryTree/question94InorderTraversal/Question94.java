package binaryTree.question94InorderTraversal;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author puka
 * @Description 二叉树的中序遍历
 * @Date 2023/5/26 10:52
 */
public class Question94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        System.out.println(Arrays.toString(new Solution().inorderTraversal2(root).toArray()));
    }
}
class Solution {
    //这里用的是递归的方式
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preOrder(out,root);
        return out;
    }

    void preOrder(List<Integer> out, TreeNode node){
        if (node == null){
            return;
        }
        preOrder(out, node.left);
        out.add(node.val);
        preOrder(out, node.right);
    }

    //使用迭代法完成中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null){
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode p = root;
        while (!stack.isEmpty()){
            while (p.left!=null){
                stack.add(p.left);
                p = p.left;
            }
            TreeNode q;
            q = stack.pop();
            out.add(q.val);
            if (q.right != null){
                stack.add(q.right);
                q = q.right;
                p = q;
            }
        }
        return out;
    }

    //使用统一的标记法完成
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null){
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                if (node.right != null){
                    stack.add(node.right);
                }
                stack.add(node);
                stack.add(null);
                if (node.left != null){
                    stack.add(node.left);
                }
            }else {
                stack.pop();
                node = stack.pop();
                out.add(node.val);
            }
        }
        return out;
    }
}