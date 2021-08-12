//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 539 👎 0

package leetcode.editor.cn;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        solution.longestPalindromeSubseq("bbbab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int dp[][] = new int[s.length()][s.length()];
            for (int left = s.length() - 1; left >= 0; left--) {
                for (int right = left; right < s.length(); right++) {
                    if (left == right) dp[left][right] = 1;
                    else if (left == right - 1) {
                        dp[left][right] = s.charAt(left) == s.charAt(right) ? 2 : 1;
                    } else if (s.charAt(left) == s.charAt(right)) {
                        dp[left][right] = 2 + dp[left + 1][right - 1];
                    } else {
                        dp[left][right] = Math.max(dp[left][right - 1], dp[left + 1][right]);
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}