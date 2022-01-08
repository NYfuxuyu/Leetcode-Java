//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 499 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result =new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len=queue.size();
            List<Integer> listitem= new ArrayList<>();
            while(len>0){
                TreeNode temp = queue.poll();
                int value=temp.val;
                listitem.add(value);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                len--;
            }
            result.add(listitem);
        }
        Collections.reverse(result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
