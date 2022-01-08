//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 做递归思考三步：
 *
 * 递归的函数要干什么？
 * 函数的作用是判断传入的两个树是否镜像。
 * 输入：TreeNode left, TreeNode right
 * 输出：是：true，不是：false
 * 递归停止的条件是什么？
 * 左节点和右节点都为空 -> 倒底了都长得一样 ->true
 * 左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
 * 左右节点值不相等 -> 长得不一样 -> false
 * 从某层到下一层的关系是什么？
 * 要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
 * 调用递归函数传入左左和右右
 * 调用递归函数传入左右和右左
 * 只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
 * 调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null
 */
class Solution_JZ_28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;
        boolean leftCompare = compare(left.left, right.right);
        boolean rightCompare = compare(left.right, right.left);
        return leftCompare && rightCompare;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
