//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 193 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
/*class Solution {

    public int[] reversePrint(ListNode head) {
        ListNode p;
        p=head;
        if(head==null){
            return new int[0];
        }
        int count=1;
        while(p.next!=null){
            p=p.next;
            count++;
        }
        int[] temp=new int[count];
        int[] res=new int[count];
        for (int i = 0; i < count; i++) {
            temp[i]=head.val;
            head=head.next;
        }
        int j=0;
        for (int i = count-1; i >= 0; i--) {

            res[j++]=temp[i];
        }
        return  res;
    }
}*/
class Solution_JZ_06 {
    List<ListNode> temp = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
       /* Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop();
        }
        return print;*/
        backtracking(head);
        int[] res = new int[temp.size()];
        int index = 0;
        for (ListNode listNode : temp) {
            res[index++] = listNode.val;
        }
        return res;
    }
    private void backtracking(ListNode head) {
        if (head == null)
            return;
        backtracking(head.next);
        temp.add(head);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
