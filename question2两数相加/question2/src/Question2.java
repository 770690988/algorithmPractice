/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Question2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(9);
        Solution solution = new Solution();
        ListNode out = solution.addTwoNumbers(l1, l2);
        StringBuffer sb = new StringBuffer();
        sb.append('[');
        while (out != null){
            sb.append(out.val);
            sb.append(',');
            out = out.next;
        }
        sb.delete(sb.length()-1,sb.length());
        sb.append(']');
        System.out.println(sb.toString());
    }

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        * 先判断p,q是否为null（pq指向l1和l2） 并附上相应的值，后续直接添加在后面的代码中
        * 最后如果有进位再重新添加即可
        */
        ListNode dummyHead = new ListNode(0);
        ListNode p=l1,q=l2,curr=dummyHead;
        int carry=0;//进位
        while(p!=null || q!=null){
            int x=(p!=null)?p.val:0;
            int y=(q!=null)?q.val:0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;
            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
        }
        if(carry>0){
            curr.next=new ListNode(carry);
        }
        return dummyHead.next;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }