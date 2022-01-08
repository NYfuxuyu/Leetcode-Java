//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2242 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0)
            return res;

        dfs("", n , n,res);
        return res;
    }
    private void dfs(String sb, int left, int right, List<String> res) {
        //终止条件
        if(left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //剪枝
        if (left > right)
            return;
        if (left > 0)
        dfs(sb+"(", left - 1, right,res);
        if (right > 0)
            //在里面相当于回溯了，因为局部变量不保存
        dfs(sb+")", left , right - 1,res);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
