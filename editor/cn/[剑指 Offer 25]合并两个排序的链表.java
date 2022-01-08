//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 👍 173 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode p = new ListNode(-1);
        ListNode head = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                p.next = new ListNode(l2.val);
                p = p.next;
                l2 = l2.next;
            } else if (l1.val == l2.val) {
                p.next = new ListNode(l1.val);
                p = p.next;
                p.next = new ListNode(l1.val);
                p = p.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
       while(l1!=null){
            p.next=new ListNode(l1.val);
             p = p.next;
            l1=l1.next;
        }
        while(l2!=null){

            p.next=new ListNode(l2.val);
            p = p.next;
            l2=l2.next;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
