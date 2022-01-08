//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics 位运算 数组 哈希表 回溯 👍 375 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_491 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0)
            return res;
        backtracking(nums, 0);
        return res;
    }
    private void backtracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
           res.add(new ArrayList<>(path));
        }
        //注意每个分支，也就是每个循环都有一个自己的used数组,同时，这个有重复数字，不能用全局的used数组
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length ; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) {
                continue;
            } else {
                used[nums[i] + 100] = 1;
                path.add(nums[i]);
                backtracking(nums, i + 1);
                path.remove(path.size() - 1);
            }

        }

    }


}
//leetcode submit region end(Prohibit modification and deletion)
