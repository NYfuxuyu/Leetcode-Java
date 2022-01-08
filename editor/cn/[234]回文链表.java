//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1167 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_234 {
    /*    public boolean isPalindrome(ListNode head) {
            ListNode p1 = head;
            ListNode p2 = head;
            Stack<Integer> stack = new Stack<>();
            while(p1 != null) {
                stack.push(p1.val);
                p1 = p1.next;
            }
            while(p2 != null) {
                if(p2.val != stack.pop()){
                    return false;
                }
            }
            return true;
        } */
    /*
    快慢指针
     */
    public boolean isPalindrome(ListNode head){
        if (head == null)
            return true;
        ListNode node = endOfFirstHalf(head);
        ListNode halfNode = reverseList(node.next);
        ListNode p1 = head;
        ListNode p2 = halfNode;
        while (p2 != null) {
            if (p2.val != p1.val)
                return false;
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
    }
    //slow是偶数的1234的2奇数的中间
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
