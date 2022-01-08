//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_JZ10_1 {
   /* int[] memeo;
    public int fib(int n) {
        memeo = new int[n + 1];
        return fib2(n);
    }
    private int fib2(int n) {
        if (n <= 1) {
            memeo[n] = n;
            return memeo[n];
        }
        if (memeo[n] > 0)
            return memeo[n];
        memeo[n] = (fib2(n - 1) + fib2(n - 2))%1000000007;
        return memeo[n];
    }*/
   public int fib(int n) {
       int a = 0, b = 1, sum;
       for (int i = 0; i < n; i++) {
           sum = (a + b) % 1000000007;
           a = b;
           b = sum;
       }
       return a;

   }
}
//leetcode submit region end(Prohibit modification and deletion)
