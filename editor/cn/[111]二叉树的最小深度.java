//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 614 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class Solution_111 {
    public int minDepth(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        if (root == null) {
//            return 0;
//        }
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            int len = queue.size();
//            depth++;
//            for (int i = 0; i < len; i++) {
//                TreeNode temp = queue.poll();
//                if (temp.left == null && temp.right == null)
//                    return depth;
//                else {
//                    if (temp.right != null)
//                        queue.offer(temp.right);
//                    if (temp.left != null)
//                        queue.offer(temp.left);
//                }
//
//            }
//
//        }
//        return 0;

        //递归版本
        // 此题需注意叶子节点的定义，比较抽象，可以想象一下输入为[1,2]的情况，
        // 此时如果单纯返回 1 + min(minDepth(root->left), minDepth(root->right))，则得 1，因为结点1的右子节点深度计算出来为 0，
        // 而实际上，节点2才是符合要求的节点。所以不能单纯的递归比较2个子节点谁的深度小。

        // 首先，节点为空，直接返回0
//        if(root == nullptr) return 0;
//
//        // 其次，若当前节点的左右子节点均存在，说明***当前节点不是叶子节点，其孩子节点的性质也无法判定***，故返回较小的孩子节点深度
//        if(root->left && root->right) return 1 + min(minDepth(root->left), minDepth(root->right));
//
//        // 最后，若当前节点的左右子节点有一个不存在，则说明***当前节点的子节点中存在叶子节点***，故返回不为空的孩子节点（叶子节点）的深度
//        // 当然了，若当前节点的左右子节点都不存在，那它就是叶子节点，总深度直接 +1 就好了，也符合这个 return 句法。
//        return 1 + max(minDepth(root->left), minDepth(root->right));
        if(root==null)
            return 0;
        if(root.left==null||root.right==null)
            return Math.max(minDepth(root.left),minDepth(root.right))+1;
         if(root.left!=null&&root.right!=null)
             return Math.min(minDepth(root.left),minDepth(root.right))+1;
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
