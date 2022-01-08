//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1667 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//代码随想录
class Solution_84 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] rheightsIndex = new int[length];
        int[] lheightsIndex = new int[length];
        int result = 0;
        lheightsIndex[0] = -1;
        for (int i = 1; i < length; i ++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) t = lheightsIndex[t];
            lheightsIndex[i] = t;
        }
        rheightsIndex[length - 1] = length;
        for (int j = length - 2; j >= 0; j--) {
            int t = j + 1;
            while (t < length && heights[t] >= heights[j] ) t = rheightsIndex[t];
            rheightsIndex[j] = t;
        }
        for (int i = 0; i < length; i++) {
            int temp = heights[i] * (rheightsIndex[i] - lheightsIndex[i] - 1);
            result = Math.max(result, temp);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
