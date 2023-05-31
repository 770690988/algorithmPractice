package binaryTree.question144PreorderTraversal;

import binaryTree.TreeNode;

import java.util.*;

/**
 * @Author puka
 * @Description 二叉树的前序遍历
 * @Date 2023/5/26 10:38
 */
public class Question144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(new Solution().preorderTraversal3(root).toArray()));
    }
}

class Solution {
    //这里用的是递归的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        preOrder(out,root);
        return out;
    }

    void preOrder(List<Integer> out, TreeNode node){
        if (node == null){
            return;
        }
        out.add(node.val);
        preOrder(out, node.left);
        preOrder(out, node.right);
    }

    //使用迭代法完成
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null){
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            out.add(pop.val);
            if (pop.right != null){
                stack.add(pop.right);
            }
            if (pop.left != null){
                stack.add(pop.left);
            }
        }
        return out;
    }

    //使用统一的标记法完成中序遍历
    public List<Integer> preorderTraversal3(TreeNode root) {
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
                if (node.left != null){
                    stack.add(node.left);
                }
                stack.add(node);
                stack.add(null);
            }else {
                stack.pop();
                node = stack.pop();
                out.add(node.val);
            }
        }
        return out;
    }
}