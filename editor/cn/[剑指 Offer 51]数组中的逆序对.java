//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 530 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        //小于2不构成逆序对
        if (len < 2)
            return 0;

        int[] temp = new int[len];
        return mergesort(nums, 0, len - 1, temp);
    }

    private int mergesort(int[] nums, int left, int right, int[] temp) {
        //归并排序的终止条件
        if (left == right)
            return 0;
        int mid = (right + left) / 2;
        int leftpairs = mergesort(nums, left, mid, temp);
        int rightpairs = mergesort(nums, mid + 1, right, temp);
        int mergepairs = merge(nums, left, mid, right, temp);

        return leftpairs + rightpairs + mergepairs;

    }

    //计算左右跨区间的个数
    private int merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i];
                i++;
            } else {
                temp[k++] = nums[j];
                j++;
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i];
            i++;

        }
        while (j <= right) {
            temp[k++] = nums[j];
            j++;
        }

        for(int t=0;t<k;t++){
            nums[left+t] = temp[t];
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
