//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
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
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int search(int[] nums, int target) {
                int count=0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==target){
                count++;
            }
        }
        return count;
    }
}*/

/**
 * 二分查找 https://www.cnblogs.com/kyoner/p/11080078.html
 */

class Solution_JZ_53_1 {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] >= target) {
                right = mid;
                //需要的是left，所以等号放在右边那里
            } else {
                left = mid + 1;
            }
        }
      /*  if (nums[left] != target)
            return 0;*/
        int count = 0;
        while (left < nums.length && nums[left++] == target) {
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
