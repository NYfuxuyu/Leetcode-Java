import sun.reflect.generics.tree.Tree;

//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 581 👎 0
class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

import javax.swing.tree.TreeNode;*/
class Solution_JZ_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //注意边界是左闭右开
       return buildTreeHelper(preorder,0, preorder.length, inorder,0, inorder.length);

    }
    private TreeNode buildTreeHelper(int[] preorder, int pleft, int pright,
                                     int[] inorder, int ileft, int iright
                                     ) {
        if (pleft == pright) {
            return null;
        }
        int root_val = preorder[pleft];
        TreeNode root = new TreeNode(root_val);
        int root_index = 0;
        for (int i = ileft; i < iright; i++) {
            if (inorder[i] == root_val) {
                root_index = i;
                break;
            }
        }
        int leftnum = root_index - ileft;
        root.left = buildTreeHelper(preorder, pleft + 1, pleft + leftnum + 1, inorder, ileft, root_index );
        root.right = buildTreeHelper(preorder, pleft + leftnum + 1 , pright, inorder, root_index + 1, iright);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
