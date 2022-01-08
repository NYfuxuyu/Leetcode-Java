//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a² + b² = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 二分查找 👍 313 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_633 {
    public boolean judgeSquareSum(int c) {
        long n= (int) Math.sqrt(c);
        long i=0;
        long j=n;
        while(i<=j){
            if(i*i+j*j==c){
                return true;
            }else if(i*i+j*j<c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
