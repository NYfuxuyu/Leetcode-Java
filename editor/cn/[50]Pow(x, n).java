//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x⁴
//
// Related Topics 递归 数学 👍 826 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_50 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1/x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
