//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 163 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
       /* if (root == null)
            return new ArrayList<>();
        boolean flag = true;
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> path = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                path.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
            if (flag) {
                res.add(path);
            } else {
                Collections.reverse(path);
                res.add(path);
            }
            flag = !flag;
        }
        return res;*/
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            //打印奇数层
            List<Integer> temp = new ArrayList<>();
           // 改成后面的的话，每次for循环结束queue.size()的大小都可能会变化，就不再是起始条件的i<queue.size()的size大小了
            //不如一开始就弄好deque的大小
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeFirst();
                temp.add(node.val);
                if (node.left != null)
                    deque.addLast(node.left);
                if (node.right != null)
                    deque.addLast(node.right);
            }
            res.add(temp);
            //打印偶数层
            if (deque.isEmpty()) break;
            temp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.removeLast();
                temp.add(node.val);
                if (node.right != null)
                    deque.addFirst(node.right);
                if (node.left != null)
                    deque.addFirst(node.left);
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
