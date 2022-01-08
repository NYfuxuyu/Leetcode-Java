//给定一棵二叉搜索树，请找出其中第 k 大的节点的值。 
//
// 
//
// 示例 1: 
//
// 
//输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 
// 1 ≤ k ≤ 二叉搜索树元素个数 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 225 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_JZ_54 {

    /*public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return 0;

        Stack<Integer> stack = new Stack<>();
        traverse(root,stack );
        int res = 0;
        for (int i = 0; i < k; i++) {
           res = stack.pop();
        }
        return res;
    }

    private void traverse(TreeNode root, Stack<Integer> stack) {
        if (root == null)
            return;
        traverse(root.left,stack);
        stack.push(root.val) ;
        traverse(root.right, stack);
    }*/
    int res, k ;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.right);
        if (k == 0)
            return;
        if (--k == 0) {
            res = root.val;
            return;
        }
        traverse(root.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
