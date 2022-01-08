//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 325 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_JZ_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int index = 0;
        int[] res = new int[(matrix.length) * (matrix[0].length)];
        int l = 0; int r = matrix[0].length - 1;
        int t = 0; int b = matrix.length - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            for (int i = t + 1; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (t!=b) {
                for (int i = r - 1; i >= l; i--) {
                    res[index++] = matrix[b][i];
                }
            }
            if (r != l) {
                for (int i = b - 1; i >= t + 1; i--) {
                    res[index++] = matrix[i][l];
                }
            }
            t++;b--;l++;r--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
