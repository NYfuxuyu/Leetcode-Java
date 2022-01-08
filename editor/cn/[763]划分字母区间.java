//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心 哈希表 双指针 字符串 👍 621 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        int[] edge = new int[26];
        char[] array = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        //更新最后出现的位置
        for (int i = 0; i < array.length; i++) {
            edge[array[i] - 'a'] = i;
        }
        int last = -1;
        int idx = 0;
        for (int i = 0; i < array.length; i++) {
            idx = Math.max(idx, edge[array[i] - 'a']);
            if (i == idx) {
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
