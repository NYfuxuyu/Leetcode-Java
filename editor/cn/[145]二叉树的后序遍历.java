//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 696 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        /*List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;*/
        List<Integer> result =new ArrayList<>();
        Deque<TreeNode> stack =new LinkedList();
        if (root == null){
            return result;
        }
        stack.push(root);
        if(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            result.add(temp.val);
            if(temp.left!=null)
                stack.push(temp.left);
            if(temp.right!=null)
                stack.push(temp.right);
        }
          Collections.reverse(result);
        return result;
    }

   /* public void postOrder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
