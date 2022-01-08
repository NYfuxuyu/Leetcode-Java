//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 932 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int l = 0; int r = matrix[0].length - 1;
        int t = 0; int b = matrix.length - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            for (int i = t + 1; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (t!=b) {
                for (int i = r - 1; i >= l; i--) {
                    res.add(matrix[b][i]) ;
                }
            }
            if (r != l) {
                for (int i = b - 1; i >= t + 1; i--) {
                    res.add(matrix[i][l]);
                }
            }
            t++;b--;l++;r--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
