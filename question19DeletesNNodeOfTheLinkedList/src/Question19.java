public class Question19 {
    public static void main(String[] args) {
        Solution out = new Solution();
        ListNode node = new ListNode(18);
        node.next = new ListNode(16,new ListNode(25,new ListNode(11)));
        int n = 1;
        ListNode outData = out.removeNthFromEnd(node, 1);
        if (outData==null) return;
        System.out.print(outData.val+"->");
        while(outData!=null && outData.next!=null){
            outData = outData.next;
            System.out.print(outData.val+"->");
        }
    }
}

class Solution {
    //但是该方法有缺陷，因为需要遍历两边时间复杂度为O(n)所以需要优化
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodeNum = 0;
        ListNode q = new ListNode();
        q.next = head;
        ListNode p = q;
        while(p.next != null){
            p = p.next;
            nodeNum++;
        }
        nodeNum = nodeNum - n;
        p = q;
        for(int i = 0; i < nodeNum; i++){
            p = p.next;
        }
        p.next = p.next.next;

        return q.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
