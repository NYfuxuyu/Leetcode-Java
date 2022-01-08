//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
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
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 476 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_JZ_12 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0|| board == null)
            return false;
        int m = board.length;
        int n = board[0].length;
        char[] arrayword = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*if (board[i][j] != word.charAt(0))
                    continue;*/
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
