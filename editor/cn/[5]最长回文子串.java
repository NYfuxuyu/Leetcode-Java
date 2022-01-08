//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4512 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_5 {

    public String longestPalindrome(String s) {
        //动态规划
      /*  int n = s.length();
        if (n < 2)
            return s;
        int maxlen = 0;
        int left= 0;
        int right = 0;
        boolean[][] dp = new boolean[n][n];
        char[] charArray = s.toCharArray();
        for (int i = n - 1; i >=0; i--) {
            for (int j = i; j < n; j++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);*/
        //中心扩散
        if (s.length() == 0 || s == null) {
            return "";
        }
        int start = 0;
        int end = 0;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandString(s, i, i);
            int len2 = expandString(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxlen) {
                maxlen = len;
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandString(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
