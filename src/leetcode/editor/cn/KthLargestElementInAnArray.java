//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 974 👎 0

package leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] arr = {3, 2, 1, 5, 6, 4};
        solution.findKthLargest(arr, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int i = -1;
            int start = 0;
            int end = nums.length - 1;
            k = k - 1;
            while (i != k) {
                i = quickSort(nums, start, end);
                if (i > k) end = i - 1;
                else if (i < k) start = i + 1;
            }
            return nums[k];
        }

        //降序
        public int quickSort(int[] nums, int start, int end) {
            if (start == end)
                return start;
            int left = start;
            int right = end;
            int key = nums[start];
            while (left < right) {
                while (nums[right] <= key && left < right) right--;
                nums[left] = nums[right];
                while (nums[left] >= key && left < right) left++;
                nums[right] = nums[left];
            }
            nums[left] = key;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}