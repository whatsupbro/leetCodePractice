//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 750 👎 0

package leetcode.editor.cn;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        solution.strStr("hello", "llo");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strStr(String haystack, String needle) {
            if (needle.length() == 0)
                return 0;
            if (haystack.length() == 0 || haystack.length() <= needle.length())
                return haystack.equals(needle) ? 0 : -1;
            int[] next = getNext(needle);
            int i = 0;
            int j = 1;
            while (i < haystack.length()) {
                if (j == 0 || haystack.charAt(i) == needle.charAt(j - 1)) {
                    if (j == needle.length())
                        return i - j + 1;
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            return -1;
        }

        public int[] getNext(String str) {
            int[] next = new int[str.length() + 1];
            if (str.length() > 0) next[1] = 0;
            int i = 1;
            int j = 0;
            while (i < str.length()) {
                if (j == 0 || str.charAt(i - 1) == str.charAt(j - 1)) {
                    i++;
                    j++;
                    if (str.charAt(i - 1) != str.charAt(j - 1)) next[i] = j;
                    else next[i] = next[j];
                } else {
                    j = next[j];
                }
            }
            return next;
        }

        public int strStr1(String haystack, String needle) {
            if (needle.length() == 0)
                return 0;
            if (haystack.length() == 0 || haystack.length() <= needle.length())
                return haystack.equals(needle) ? 0 : -1;
            int index = -1;
            boolean[][] dp = new boolean[needle.length()][haystack.length()];
            for (int i = 0; i < needle.length(); i++) {
                for (int j = 0; j < haystack.length(); j++) {
                    dp[i][j] = needle.charAt(i) == haystack.charAt(j);
                    if (i > j)
                        dp[i][j] = false;
                    else if (i > 0 && j > 0)
                        dp[i][j] &= dp[i - 1][j - 1];
                    if (i == needle.length() - 1 && dp[i][j]) {
                        index = j - needle.length() + 1;
                        break;
                    }
                }
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}