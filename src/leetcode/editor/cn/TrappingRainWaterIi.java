//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例： 
//
// 给出如下 3x6 的高度图:
//[
//  [1,4,3,1,3,2],
//  [3,2,1,3,2,4],
//  [2,3,3,2,3,1]
//]
//
//返回 4 。
// 
//
// 
//
// 如上图所示，这是下雨前的高度图{{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}} 的状态。 
//
// 
//
// 
//
// 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 110 
// 0 <= heightMap[i][j] <= 20000 
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 
// 👍 361 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterIi {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWaterIi().new Solution();
        int[][] data = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        int[][] data2 = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        int[][] data3 = {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        solution.trapRainWater(data3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int re = 0;

        public class Location {
            int row, col, height;

            public Location(int row, int col, int height) {
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            PriorityQueue<Location> queue = new PriorityQueue<>(Comparator.comparing(x -> x.height));
            int row = heightMap.length;
            int column = heightMap[0].length;
            boolean[][] visited = new boolean[row][column];
            int visitedNum = column * row;
            for (int i = 0; i < row; i++) {
                queue.add(new Location(i, 0, heightMap[i][0]));
                queue.add(new Location(i, column - 1, heightMap[i][column - 1]));
                visited[i][0] = true;
                visited[i][column - 1] = true;
                visitedNum -= 2;
            }
            for (int i = 1; i < column - 1; i++) {
                queue.add(new Location(0, i, heightMap[0][i]));
                queue.add(new Location(row - 1, i, heightMap[row - 1][i]));
                visited[0][i] = true;
                visited[row - 1][i] = true;
                visitedNum -= 2;
            }
            while (visitedNum > 0) {
                Location cur = queue.poll();
                int c = cur.col + 1;
                int r = cur.row;
                if (c >= 0 && c < column && r >= 0 && r < row && !visited[r][c]) {
                    visited[r][c] = true;
                    visitedNum--;
                    deal(r, c, heightMap, queue, visited);
                }
                c = cur.col - 1;
                r = cur.row;
                if (c >= 0 && c < column && r >= 0 && r < row && !visited[r][c]) {
                    visited[r][c] = true;
                    visitedNum--;
                    deal(r, c, heightMap, queue, visited);
                }
                c = cur.col;
                r = cur.row - 1;
                if (c >= 0 && c < column && r >= 0 && r < row && !visited[r][c]) {
                    visited[r][c] = true;
                    visitedNum--;
                    deal(r, c, heightMap, queue, visited);
                }
                c = cur.col;
                r = cur.row + 1;
                if (c >= 0 && c < column && r >= 0 && r < row && !visited[r][c]) {
                    visited[r][c] = true;
                    visitedNum--;
                    deal(r, c, heightMap, queue, visited);
                }
            }
            return re;
        }

        public void deal(int r, int c, int[][] heightMap, PriorityQueue<Location> queue, boolean[][] visited) {
            int height = Integer.MAX_VALUE;
            int row = r - 1;
            int col = c;
            if (row >= 0 && row < visited.length && col > 0 && col < visited[0].length && visited[row][col]) {
                height = Math.min(height, heightMap[row][col]);
            }
            row = r + 1;
            col = c;
            if (row >= 0 && row < visited.length && col > 0 && col < visited[0].length && visited[row][col]) {
                height = Math.min(height, heightMap[row][col]);
            }
            row = r;
            col = c + 1;
            if (row >= 0 && row < visited.length && col > 0 && col < visited[0].length && visited[row][col]) {
                height = Math.min(height, heightMap[row][col]);
            }
            row = r;
            col = c - 1;
            if (row >= 0 && row < visited.length && col > 0 && col < visited[0].length && visited[row][col]) {
                height = Math.min(height, heightMap[row][col]);
            }
            re += Math.max(0, height - heightMap[r][c]);
            heightMap[r][c] = Math.max(height, heightMap[r][c]);
            queue.add(new Location(r, c, heightMap[r][c]));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}