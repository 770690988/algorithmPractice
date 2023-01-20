class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Question24 {
    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode head = new ListNode();
        Solution out = new Solution();
        ListNode outData = out.swapPairs(head);
        while (outData != null){
            System.out.print(outData.val + "->");
            outData = outData.next;
        }
    }
}

class Solution {
    /**
     * 太快乐了，一遍过！！！
     * @param head
     * @return ListNode
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode qHead = new ListNode();
        qHead.next = head;
        ListNode first = qHead.next;
        ListNode second = first.next;
        ListNode out = qHead;
        while(first != null && second != null){
            qHead.next = second;
            first.next = second.next;
            second.next = first;
            qHead = first;
            first = qHead.next;
            if (first == null) break;
            second = first.next;
        }

        return out.next;
    }
}