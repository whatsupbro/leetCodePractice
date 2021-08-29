//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 523 👎 0

package leetcode.editor.cn;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfRepeatedSubarray().new Solution();
        int[] aa = {1, 2, 3, 2, 1};
        int[] bb = {3, 2, 1, 4, 7};
        solution.findLength(aa, bb);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findLength(int[] nums1, int[] nums2) {
            return nums1.length <= nums2.length ? findLength1(nums1, nums2) : findLength1(nums2, nums1);
        }

        public int findLength1(int[] nums1, int[] nums2) {
            int max = 0;
            int la = nums1.length;
            int lb = nums2.length;
            for (int i = 0; i < la; i++) {
                max = Math.max(max, match(nums1, nums2, 0, lb - 1 - i, i + 1));
            }
            for (int i = lb - la - 1; i >= 0; i++) {
                max = Math.max(max, match(nums1, nums2, 0, i, la));
            }
            for (int i = 1; i < la; i++) {
                if (max < la - i) {
                    max = Math.max(max, match(nums1, nums2, i, 0, la - i));
                } else {
                    break;
                }
            }

            return max;
        }

        public int match(int[] nums1, int[] nums, int i, int j, int len) {
            System.out.println("i:" + i + ",j:" + j + ",len:" + len);
            int max = 0;
            int now = 0;
            for (int k = 0; k < len; k++) {
                if (nums1[k + i] == nums[j + k]) {
                    now++;
                } else {
                    max = Math.max(max, now);
                    now = 0;
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}