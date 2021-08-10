//有效数字（按顺序）可以分成以下几个部分： 
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下： 
//
// 
// ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
// "53.5e93", "-123.456e789"] 
// 
//
// 部分无效数字列举如下： 
//
// 
// ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
// 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = ".1"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
// Related Topics 字符串 
// 👍 271 👎 0

package leetcode.editor.cn;

public class ValidNumber {
    public static void main(String[] args) {
        Solution solution = new ValidNumber().new Solution();
        solution.isNumber("0..");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            int start = 0;
            int end = s.length();
            if (s.charAt(start) == '+' || s.charAt(start) == '-') {
                start++;
            }
            int dot = s.indexOf(".");
            int e = s.indexOf("e");
            if (dot < 0 && e < 0) {
                return isInteger(s.substring(start));
            } else if (dot < 0 && e >= 0) {
                return isInteger(s.substring(start, e)) && isInteger(s.substring(e + 1, end));
            } else if (e < 0 && dot >= 0) {
                boolean re = true;
                if (dot != start) re = re && isInteger(s.substring(start, dot));
                if (dot != end) re = re && isInteger(s.substring(dot + 1, end));
                return re;
            } else if (dot >= e) {
                return false;
            } else {
                boolean re = true;
                if (dot != start) re = re && isInteger(s.substring(start, dot));
                if (dot != e - 1) re = re && isInteger(s.substring(dot + 1, e));
                if (dot == start && dot == e - 1) return false;
                return re && isInteger(s.substring(e + 1, end));
            }
        }


        public boolean isInteger(String s) {
            if (s.length() == 0) return false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}