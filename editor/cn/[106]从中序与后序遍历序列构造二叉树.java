//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 609 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
class Solution_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            return trasval(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    private TreeNode trasval(int[] inorder, int inleft, int inright,
                             int[] postorder, int postleft, int postright) {
        if (inright - inleft == 0) {
            return null;
        }
//        if (inright - inleft == 1) {
//            return new TreeNode(inorder[inleft]);
//        }
        // 后序数组postorder里最后一个即为根结点
        int rootValue = postorder[postright - 1];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inleft; i < inright; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
            }
        }
        root.left = trasval(inorder, inleft, rootIndex,postorder,postleft,postleft+rootIndex-inleft);
        root.right = trasval(inorder,rootIndex+1,inright,postorder,postleft+rootIndex-inleft,postright-1);
        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
