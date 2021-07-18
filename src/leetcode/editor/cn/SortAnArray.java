//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 313 👎 0

package leetcode.editor.cn;

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSortArray(nums, 0, nums.length - 1);
            return nums;
        }

        public void quickSortArray(int[] nums, int left, int right) {
            if (left >= right) return;
            int key = nums[left];
            int leftIndex = left;
            int rightIndex = right;
            while (left < right) {
                while (left < right && nums[right] >= key) right--;
                nums[left] = nums[right];
                while (left < right && nums[left] <= key) left++;
                nums[right] = nums[left];
            }
            nums[left] = key;
            quickSortArray(nums, leftIndex, left - 1);
            quickSortArray(nums, right + 1, rightIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}