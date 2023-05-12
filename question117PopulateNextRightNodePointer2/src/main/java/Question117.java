import java.util.*;

public class Question117 {
    public static void main(String[] args) {

    }
}


class Solution {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node p;
        while(!queue.isEmpty()){
            int levelCount = queue.size();
            Node head = null;
            for (int i = 0; i < levelCount; i++) {
                p = queue.poll();
                if (head != null) {
                    head.next = p;
                }
                head = p;
                if (p.left != null){
                    queue.add(p.left);
                }
                if (p.right != null){
                    queue.add(p.right);
                }
            }
            head.next = null;
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

