//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 749 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_438 {
    /**
     * 除了直接比较数组是否相等外，其实还可以用双指针来表示滑动窗口的两侧边界，当滑动窗口的长度等于p的长度时，表示找到一个异位词，两种方式的时间复杂度都是O(n)级别的
     * 先说结论，Python用数组更快一点点（差不太多其实），Java用双指针更快一点，下面是具体步骤：
     *
     * 定义滑动窗口的左右两个指针left，right
     * right一步一步向右走遍历s字符串
     * right当前遍历到的字符加入s_cnt后不满足p_cnt的字符数量要求，将滑动窗口左侧字符不断弹出，也就是left不断右移，直到符合要求为止。
     * 当滑动窗口的长度等于p的长度时，这时的s子字符串就是p的异位词。
     * 其中，left和right表示滑动窗口在字符串s中的索引，cur_left和cur_right表示字符串s中索引为left和right的字符在数组中的索引
     *
     * 作者：edelweisskoko
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();int m = p.length();
        if (n < m) return res;
        int[] p_cnt = new int[26];
        int[] s_cnt = new int[26];
        for (int i = 0; i < m; i++) {
            p_cnt[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            int curRight = s.charAt(right) - 'a';
            s_cnt[curRight]++;
            while (s_cnt[curRight] > p_cnt[curRight]) {
                int curLeft = s.charAt(left) - 'a';
                s_cnt[curLeft]--;
                left++;
            }
            if (right - left +1 == m) {
                res.add(left);
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
