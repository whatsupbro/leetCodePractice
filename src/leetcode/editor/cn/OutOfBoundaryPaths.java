//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//109 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 177 👎 0

package leetcode.editor.cn;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        Solution solution = new OutOfBoundaryPaths().new Solution();
        System.out.println(solution.findPaths(2, 4, 5, 1, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            int result = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != 0 && j != 0 && i != m - 1 && j != n - 1) {
                        break;
                    }
                    int rLen = Math.abs(startRow -i);
                    int cLen = Math.abs(startColumn - j);
                    int type = i == 0 || i == n - 1 ? 2 : 1;
                    if (rLen + cLen + 1 <= maxMove) {
                        result += combination(rLen, cLen, type);
                        result %= 10e9 + 7;
                    }
                }
            }
            return result;
        }

        public double combination(int a, int b, int type) {
            int s = a + b;
            a = Math.min(a, b);
            double re = type;
            for (int i = s; i > s - a; i--) {
                re *= i;
                re %= (10e9 + 7);
            }
            for (int i = a; i >= 1; i--) re /= i;
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}