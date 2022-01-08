//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
// Related Topics 数组 二分查找 👍 640 👎 0


import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_162 {
    //二分+单调栈
    /*public int findPeakElement(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }

        int i=0;
        int j=nums.length-1;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] > nums [mid+1]&&nums[mid]>nums[mid-1]){
                return mid;
            }else if(nums[mid+1]>nums[mid]){
                i = mid+1;
            }else if(nums[mid-1]>nums[mid]){
               j = mid-1;
            }
        }
        return 0;
    }*/
    public int findPeakElement(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[nums.length-1] > nums[nums.length-2]){
            return nums.length-1;
        }
        Stack<Integer> stack =new Stack<>();
        for (int i = 0; i < nums.length; i++) {
             if (nums[i+1] > nums[i]) {
                stack.push(i);
            }
            else {
                return i;
             }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
