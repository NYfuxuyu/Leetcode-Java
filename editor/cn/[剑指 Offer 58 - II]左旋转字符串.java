//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_JZ58_2 {
    public String reverseLeftWords(String s, int n) {
    /*    String s1= s.substring(0,n);
        String s2=s.substring(n);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(s2);
        stringBuilder.append(s1);
        return stringBuilder.toString();*/
        //不使用额外的空间，来做这题，代码随想录
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars,0 ,s.length() - 1);
        return new String(chars);
    }
    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
