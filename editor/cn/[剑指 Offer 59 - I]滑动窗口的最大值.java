//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 326 👎 0


import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution_JZ_59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k < 1) {
            return nums;
        }
        PriorityQueue<Integer> priorityQueue  = new PriorityQueue<>((a, b) -> b - a);
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }
        result[index++] = priorityQueue.peek();
        for (int i = 0, j = k; j < nums.length; i++, j++ ) {
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[j]);
            result[index++] = priorityQueue.peek();
        }

        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
