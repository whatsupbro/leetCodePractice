//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1251 👎 0

package leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] arr = {3, 2, 1, 0, 4};
        solution.canJump(arr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //贪心：能跳到最远的距离
        public boolean canJump(int[] nums) {
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > k) return false;
                k = Math.max(k, i + nums[i]);
            }
            return true;
        }

        public boolean canJump1(int[] nums) {
            return canJump(nums, 0);

        }


        public boolean canJump(int[] nums, int index) {
            if (index == nums.length - 1) {
                return true;
            }
            if (nums[index] == 0) {
                return false;
            }
            int jump = nums[index];
            for (int i = 1 + index; i <= jump + index; i++) {
                if (i >= nums.length) {
                    break;
                }
                if (canJump(nums, i)) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}