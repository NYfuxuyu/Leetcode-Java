//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 👍 568 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] flags = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flags[nums[i]]++;
        }
        for (int i = 0; i < flags.length; i++) {
            if(flags[i]>1){
                return i;
            }

        }
        return 0;
    }
}*/
class Solution03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
