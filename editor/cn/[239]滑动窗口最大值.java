//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-1], k = 1
//输出：[1,-1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [9,11], k = 2
//输出：[11]
// 
//
// 示例 5： 
//
// 
//输入：nums = [4,-2], k = 2
//输出：[4] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1305 👎 0


import java.util.Deque;
import java.util.LinkedList;
/*if(nums == null || nums.length < 2) return nums;
     // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
     LinkedList<Integer> queue = new LinkedList();
     // 结果数组
     int[] result = new int[nums.length-k+1];
     // 遍历nums数组
     for(int i = 0;i < nums.length;i++){
         // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
         while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
             queue.pollLast();
         }
         // 添加当前值对应的数组下标
         queue.addLast(i);
         // 判断当前队列中队首的值是否有效
         if(queue.peek() <= i-k){
             queue.poll();
         }
         // 当窗口长度为k时 保存当前窗口中最大值
         if(i+1 >= k){
             result[i+1-k] = nums[queue.peek()];
         }
     }
     return result;*/
//leetcode submit region begin(Prohibit modification and deletion)
class MyQueue {
    Deque<Integer> queue = new LinkedList<>();
    void poll(int value) {
        if (!queue.isEmpty() && queue.peek() == value ) {
            queue.pop();
        }
    }
    void add(int value) {
        while (!queue.isEmpty() && value > queue.getLast()) {
            queue.removeLast();
        }
        queue.add(value);
    }
    int front() {
        return queue.peek();
    }
}
class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k < 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        int index = 0;
        result[index++] = queue.front();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            result[index++] = queue.front();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
