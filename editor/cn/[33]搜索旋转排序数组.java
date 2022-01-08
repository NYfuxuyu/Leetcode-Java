//整数数组 nums 按升序排列，数组中的值 互不相同 。 
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 👍 1749 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_33 {
    //联系一下JZ_53_1
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = (left + right + 1)/2;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
/*
           这个时候就已经找到旋转点了，原数组的最大边界值那里left=right
           这时候只要判断target与nums[0]的大小来判断处于0-left还是right-(size-1)中
         */
        if (target >= nums[0]) {
            left = 0;
        } else {
            right = nums.length - 1;
            left++;
        }
        while (left < right) {
            int mid = (left + right )/2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid ;
            }
        }
        return nums[right] == target ?right:-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
