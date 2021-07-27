//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2237 👎 0

package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] iii = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        solution.trap(iii);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trap(int[] height) {
            int sum = 0;
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < height.length; i++) {
                while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                    int curH = stack.pop();
                    curH = height[curH];
                    if (!stack.isEmpty()) {
                        curH = Math.min(height[stack.peek()], height[i]) - curH;
                        sum += curH * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
            return sum;
        }


        public int trap1(int[] height) {
            if (height.length <= 2) return 0;
            int re = 0;
            int max = 0;
            int curMax = height[0];
            int dup = 0;
            for (int i = 0; i < height.length; i++) {
                if (curMax < height[i]) curMax = height[i];
                re += curMax;
                max = Math.max(max, curMax);
                dup += height[i];
            }
            curMax = height[height.length - 1];
            System.out.println(re);
            for (int i = height.length - 1; i >= 0; i--) {
                if (curMax < height[i]) curMax = height[i];
                re += curMax;
            }
            return re - max * height.length - dup;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}