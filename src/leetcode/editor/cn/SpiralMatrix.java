//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 822 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        int[][] matrix = {{-2, -3, 3, 1}, {-5, -10, 1, 2}, {10, 30, -5, 3}};
        int[][] matrix1 = {{1}};
        solution.spiralOrder(matrix1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> list = new ArrayList<>();
            if (matrix.length == 0) return list;
            int[][] visited = new int[matrix.length][matrix[0].length];
            int column = 0, row = 0, direction = 0, num = matrix.length * matrix[0].length;
            while (num > 0) {
                list.add(matrix[column][row]);
                visited[column][row] = 1;
                num--;
                int[] record = canVisited(visited, column, row, direction);
                column = record[0];
                row = record[1];
                direction = record[2];
            }
            return list;
        }

        public int[] canVisited(int[][] visited, int c, int r, int direction) {
            int[] re = new int[3];
            boolean canVisited = false;
            switch (direction) {
                case 0:
                    if (r + 1 < visited[0].length) {
                        canVisited = visited[c][r + 1] == 0 ? true : false;
                    }
                    if (canVisited) r = r + 1;
                    else c = c + 1;
                    break;
                case 1:
                    if (c + 1 < visited.length) {
                        canVisited = visited[c + 1][r] == 0 ? true : false;
                    }
                    if (canVisited) c = c + 1;
                    else r = r - 1;
                    break;
                case 2:
                    if (r - 1 >= 0) {
                        canVisited = visited[c][r - 1] == 0 ? true : false;
                    }
                    if (canVisited) r = r - 1;
                    else c = c - 1;
                    break;
                case 3:
                    if (c - 1 >= 0) {
                        canVisited = visited[c - 1][r] == 0 ? true : false;
                    }
                    if (canVisited) c = c - 1;
                    else r = r + 1;
                    break;
            }
            if (!canVisited) direction++;
            direction %= 4;
            re[0] = c;
            re[1] = r;
            re[2] = direction;
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}