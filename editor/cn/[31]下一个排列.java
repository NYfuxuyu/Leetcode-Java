//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1461 👎 0


import java.util.Collection;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int i = nums.length - 2;
        int j = nums.length - 1;
        int k = nums.length - 1;
       while (i > 0 && nums[i] >= nums[j]) {
           i--;
           j--;
       }
       if (i == 0 && nums[i] > nums[j]) {
           reverse(nums,0,nums.length - 1);
           return;
       }
       while (k >= j && nums[k] <= nums[i]) {
           k--;
       }
       swap(nums,i,k);
       reverse(nums, j ,nums.length - 1);
       return;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i ,j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
