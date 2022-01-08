//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_79 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0|| board == null)
            return false;
        int m = board.length;
        int n = board[0].length;
        char[] arrayword = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, arrayword, 0, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j,char[] arrayword, int start, boolean[][] visited) {
        if (i < 0|| i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != arrayword[start] || visited[i][j]) {
            return false;
        }
        if (start == arrayword.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        res = dfs(board, i + 1, j, arrayword, start + 1, visited) ||
                dfs(board, i , j + 1, arrayword, start + 1, visited) ||
                dfs(board, i - 1, j, arrayword, start + 1, visited) ||
                dfs(board, i , j - 1, arrayword, start + 1, visited);
        visited[i][j] = false;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
