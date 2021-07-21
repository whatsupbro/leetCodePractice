//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 959 👎 0

package leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEC";
        System.out.println(solution.exist(board, word));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int[][] visited = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (exist(board, word, visited, i, j, 0)) return true;
                    }
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word, int[][] visited, int i, int j, int index) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1) return false;
            if (word.charAt(index) == board[i][j]) {
                if (index == word.length() - 1) {
                    return true;
                } else {
                    visited[i][j] = 1;
                    boolean re = exist(board, word, visited, i + 1, j, index + 1) | exist(board, word, visited, i, j + 1, index + 1)
                            | exist(board, word, visited, i - 1, j, index + 1) | exist(board, word, visited, i, j - 1, index + 1);
                    visited[i][j] = 0;
                    return re;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}