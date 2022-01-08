//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 792 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
/*class Solution_110 {
    public boolean isBalanced(TreeNode root) {
            return getDepth(root)!=-1;
    }

    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getDepth(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = getDepth(root.right);
        if(rightHeight == -1) return  -1;
        if(Math.abs((leftHeight - rightHeight))>1){
            return -1;
        }else {
            return Math.max(getDepth(root.left),getDepth(root.right))+1;
        }
    }

}*/
class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public static class  ResultType{
        boolean isBalanced;
        int height;

        public ResultType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ResultType process(TreeNode root) {
            if (root == null)
                return new ResultType(true,0);

            ResultType leftTree = process(root.left);
            ResultType rightTree = process(root.right);

            int height = Math.max(leftTree.height,rightTree.height) + 1;
            boolean flag = leftTree.isBalanced && rightTree.isBalanced && Math.abs(leftTree.height
                    - rightTree.height )<=1 ;
            return new ResultType(flag,height);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
