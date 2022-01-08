//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。 
//
// 差值是一个正数，其数值等于两值之差的绝对值。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [4,2,6,1,3]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [1,0,48,null,null,12,49]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [2, 10⁴] 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 284 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



import java.util.ArrayList;
import java.util.List;

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
class Solution_530 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        travsal(root);
        if (list.size()<2) return 0;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1)-list.get(i)<=min){
                min = list.get(i+1)-list.get(i);
            }
        }
            return min;
    }

    private void travsal(TreeNode root) {
        if (root == null) {
            return;
        }
        travsal(root.left);
        list.add(root.val);
        travsal(root.right);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
