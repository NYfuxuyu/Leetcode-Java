//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1351 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int[] res = new int[]{-1, -1};
        if (nums.length == 0)
            return res;
        //寻找左边界,最后的结果为最小的比target的数的边界
        while (l < r) {
            int mid = (l + r) >> 1;
            if(nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //这里就包含了没有找到target的情况
        if (nums[l] != target) return res;
        res[0] = l;

        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if(nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        res[1] = r;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
