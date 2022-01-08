//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 2939 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_42 {
    /*public int trap(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            if (i == 0 || i == height.length) {
                continue;
            }

            int rheight = height[i];
            int lheight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rheight) {
                    rheight = height[j];
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] >lheight) {
                    lheight = height[j];
                }
            }
            int temp = Math.min(lheight, rheight) - height[i];
            if (temp > 0) {
                count += temp;
            }
        }
        return count;
    }*/
    //动态规划
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int count = 0;
        int[] lheight = new int[height.length];
        int[] rheight = new int[height.length];
        lheight[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lheight[i]  = Math.max(height[i], lheight[i - 1]);
        }
        rheight[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rheight[j] = Math.max(height[j], rheight[j + 1] );
        }
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(rheight[i], lheight[i]);
            if (temp - height[i] > 0) {
                count += temp - height[i];
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
