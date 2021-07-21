//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 109 
// 
// Related Topics 数学 动态规划 组合数学 
// 👍 1052 👎 0

package leetcode.editor.cn;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 可以用排列组合来解题，m=7，n=3
         * 说明向右要走m-1步，向下要走n-1步。
         * 结果就是在m+n-2步里选m-1步向右走，或者是m+n-2步里选n-1步向下走
         * 可以用组合数C m+n-2 m-1
         * */
        public int uniquePaths(int m, int n) {
            if (m <= 1 && n <= 1) {
                return m * n;
            }
            m--;
            n--;
            int sum = m + n;
            //防止数超过int
            long re = 1;
            //实际上选m,n都可以 结果是一样的 但是选个小的 优化计算量
            m = Math.min(m, n);
            //根据组合数公式计算即可
            for (int i = 0; i < m; i++) {
                re *= sum;
                sum--;
            }
            for (int i = 0; i < m; i++) {
                re /= m - i;
            }
            return (int) re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}