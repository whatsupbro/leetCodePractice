//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1200 👎 0

package leetcode.editor.cn;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] arr = {1, 2, 3, 8, 5, 7, 6, 4};
        //int[] arr = {2, 3, 1, 3, 3};
        solution.nextPermutation(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) return;
            //从后向前找第一个逆序对
            int i = nums.length - 2;
            int j = nums.length - 1;
            while (i >= 0) {
                if (nums[i] >= nums[j]) {
                    i--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0) {
                //找到nums[j]到结束比nums[i]大的最小的数
                int min = nums[j];
                for (int p = i + 2; p < nums.length; p++) {
                    if (nums[p] > nums[i] && nums[p] < min) {
                        j = p;
                        min = nums[j];
                    }
                }
                //交换i ,j
                nums[j] = nums[i];
                nums[i] = min;
            }
            //交换后面几位
            int l = nums.length - 1;
            for (int p = i + 1; p < l; p++) {
                if (nums[p] <= nums[p + 1]) break;
                int cur = nums[p];
                nums[p] = nums[l];
                nums[l] = cur;
                l--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}