//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 203 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;

//leetcode submit region begin(Prohibit modification and deletion)

/*class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > nums.length / 2) {
                    return entry.getKey();
                }
            }

        }
        return -1;
    }
}*/
class Solution_JZ_39 {
    public int majorityElement(int[] nums) {
        int candidate_num = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
                if (candidate_num == nums[i]) {
                    count++;
                }else {
                    if (--count == 0) {
                        candidate_num = nums[i];
                        count = 1;
                    }
                }
        }
        return candidate_num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
