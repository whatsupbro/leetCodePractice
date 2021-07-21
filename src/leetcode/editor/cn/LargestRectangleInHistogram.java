//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1445 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] heights = {1,1};
        solution.largestRectangleArea(heights);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights.length == 0) return 0;
            if (heights.length == 1) return heights[0];
            int size = 0;
            int[] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[heights.length + 1] = 0;
            System.arraycopy(heights, 0, newHeights, 1, heights.length);
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 0; i < newHeights.length; i++) {
                while (newHeights[i] < newHeights[stack.peek()]) {
                    int height = newHeights[stack.pop()];
                    int width = i - stack.peek() - 1;
                    size = Math.max(size, height * width);
                }
                stack.add(i);
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}