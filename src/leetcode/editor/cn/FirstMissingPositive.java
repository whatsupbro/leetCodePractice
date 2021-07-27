//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1145 👎 0

package leetcode.editor.cn;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        int[] arr = {1, 2, 0};
        solution.firstMissingPositive(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                //注意 这里要用nums[nums[i] - 1] != nums[i]而不用 i-1 != nums[i]
                //理由是：要判断即将换的位置上是否是正确的值 而不是 当前位置上是否是正确的值
                //防止在case = [1,1]  情况下进入死循环！！
                while (nums[i] > 0 && nums[i] <= nums.length&& nums[nums[i] - 1] != nums[i]) {
                    int dup = nums[i];
                    nums[i] = nums[dup - 1];
                    nums[dup - 1] = dup;
                }
            }
            int j = 0;
            for (j = 0; j < nums.length; j++) {
                if (nums[j] != j + 1) break;
            }
            return j + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}