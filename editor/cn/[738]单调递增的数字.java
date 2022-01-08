//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。 
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。） 
//
// 示例 1: 
//
// 输入: N = 10
//输出: 9
// 
//
// 示例 2: 
//
// 输入: N = 1234
//输出: 1234
// 
//
// 示例 3: 
//
// 输入: N = 332
//输出: 299
// 
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。 
// Related Topics 贪心 数学 👍 214 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_738 {
    public int monotoneIncreasingDigits(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int flag = Integer.MAX_VALUE;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                array[i - 1]--;
                flag = i;
            }
        }
        for (int i = flag; i < array.length; i++) {
            array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
