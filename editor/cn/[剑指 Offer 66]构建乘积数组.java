//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//leetcode视频题解
class Solution_JZ_66 {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int k = 1;
        //求前缀和存在答案数组里面
        for (int i = 0; i < a.length; i++) {
            res[i] = k;
            k *= a[i];
        }
        k = 1;
        //求后缀和
        for (int j = a.length - 1; j >= 0; j--) {
            res[j] *= k;
            k *=a[j];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
