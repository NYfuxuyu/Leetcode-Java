//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 429 👎 0



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 这是不重复的全排列的情况
 */
/*class Solution {
    List<String> res =new ArrayList<>();
    LinkedList<Character> path=new LinkedList<>();
    public String[] permutation(String s) {

        if (s.length()==0)
            return null;
        backtracking(s,path);
        String[] result=new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i]=res.get(i);
        }
        return result;
    }

        private void backtracking(String s, LinkedList<Character> path){
            char[] array = s.toCharArray();
            if(path.size()==array.length)
            {   StringBuilder sb=new StringBuilder();
                for (Character character : path) {
                    sb.append(character);
                }
                res.add(sb.toString());
            }

               for (int i = 0; i < array.length; i++) {
                    if(path.contains(array[i]))
                        continue;

                        path.add(array[i]);
                        backtracking(s,path);
                        path.removeLast();

                }

        }

}*/
class Solution_JZ_38 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        char[] array = s.toCharArray();
        boolean[] used = new boolean[array.length];
        Arrays.sort(array);
        backtracing(array, used);

        return res.toArray(new String[0]);
    }

    private void backtracing(char[] array, boolean[] used) {
        if (array.length == sb.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1] && used[i - 1] == false)
                continue;
            if (used[i] == false) {
                used[i] = true;
                sb.append(array[i]);
                backtracing(array, used);
                sb.deleteCharAt(sb.length()- 1);
                used[i] = false;
            }

        }
    }
}//leetcode submit region end(Prohibit modification and deletion)
