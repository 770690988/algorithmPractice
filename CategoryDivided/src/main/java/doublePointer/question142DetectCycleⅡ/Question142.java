package doublePointer.question142DetectCycleⅡ;

/**
 * @Author puka
 * @Description 环形链表 II
 * @Date 2023/7/11 13:57
 */
public class Question142 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(9);
        node.next.next.next.next = node.next.next;
        ListNode outNode = new Solution().detectCycle(node);

        if (outNode != null){
            System.out.println(outNode.val);
        }else {
            System.out.println("null");
        }
    }
}


class Solution {
    public ListNode detectCycle(ListNode head) {
        //使用双指针的方法
        ListNode fast = head, slow = head;
        while (fast != null && slow != null && fast.next != null){
            fast = fast.next.next;//快指针一次跳两格
            slow = slow.next;//慢指针一次跳一次
            if (fast == slow){//表明是碰到的是同一个节点，即存在环的情况
                return getCycleNode(fast,head);
            }
        }
        return null;
    }

    private ListNode getCycleNode(ListNode fast, ListNode head) {
        ListNode pointer = head;
        while (fast != pointer){
            fast = fast.next;
            pointer = pointer.next;
        }
        return pointer;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}