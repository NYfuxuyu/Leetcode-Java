//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 324 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution_57_2 {
    public int[][] findContinuousSequence(int target) {
        if (target < 3)
            return new int[0][];
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int j = 2;
        int sum = 3;
        while (i < j) {
            if (sum > target) {
                sum -= i;
                i++;
            } else if (sum == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}



//leetcode submit region end(Prohibit modification and deletion)
