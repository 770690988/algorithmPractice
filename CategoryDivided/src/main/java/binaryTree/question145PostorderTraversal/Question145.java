package binaryTree.question145PostorderTraversal;

import binaryTree.TreeNode;

import java.util.*;

/**
 * @Author puka
 * @Description 二叉树的后序遍历
 * @Date 2023/5/26 10:49
 */
public class Question145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new Solution().postorderTraversal(root).toArray()));
    }
}

class Solution {
    //这里用的是递归的方式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preOrder(out,root);
        return out;
    }

    void preOrder(List<Integer> out, TreeNode node){
        if (node == null){
            return;
        }
        preOrder(out, node.left);
        preOrder(out, node.right);
        out.add(node.val);
    }

    //使用迭代法完成后续遍历的操作
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null){
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            out.add(pop.val);
            if (pop.left != null){
                stack.add(pop.left);
            }
            if (pop.right != null){
                stack.add(pop.right);
            }
        }
        Collections.reverse(out);
        return out;
    }

    //使用统一的标记法完成后序遍历
    public List<Integer> postorderTraversal3(TreeNode root) {
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
                stack.add(node);
                stack.add(null);
                if (node.right != null){
                    stack.add(node.right);
                }
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