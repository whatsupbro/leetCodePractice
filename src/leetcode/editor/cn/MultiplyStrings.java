//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 模拟 
// 👍 658 👎 0

package leetcode.editor.cn;

public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("80", "133"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            //确定正负位数
            boolean fushu = false;
            if (num1.charAt(0) == '-') {
                fushu = !fushu;
                num1 = num1.substring(1);
            }
            if (num2.charAt(0) == '-') {
                fushu = !fushu;
                num2 = num2.substring(1);
            }
            //如果都是一位
            if (num1.length() == 1 && num2.length() == 1) {
                int re = (num1.charAt(0) - '0') * (num2.charAt(0) - '0');
                return fushu ? String.valueOf(-re) : String.valueOf(re);
            }
            String result = "";
            if (num1.length() > 1) {
                result = getString(num2, num1, result);
            } else {
                result = getString(num1, num2, result);
            }
            return fushu ? "-" + result : result;
        }

        private String getString(String num1, String num2, String result) {
            int len = num2.length();
            for (int i = 0; i < len; i++) {
                String sub = num2.substring(i, i + 1);
                String re = multiply(sub, num1);
                for (int j = 0; j < len - i - 1; j++) {
                    re += '0';
                }
                result = strAdd(result, re);
            }
            return result;
        }

        public String strAdd(String num1, String num2) {
            if (num1.length() == 0) return num2;
            StringBuilder stringBuilder = new StringBuilder(num1.length() + 1);
            int pa = num1.length() - 1;
            int pb = num2.length() - 1;
            int b = 0;
            while (pa >= 0 || pb >= 0) {
                char ch1 = '0';
                if (pa >= 0) {
                    ch1 = num1.charAt(pa);
                }
                char ch2 = '0';
                if (pb >= 0) {
                    ch2 = num2.charAt(pb);
                }
                int addResult = ch1 + ch2 - '0' - '0' + b;
                if (addResult >= 10) {
                    addResult -= 10;
                    b = 1;
                } else {
                    b = 0;
                }
                pa--;
                pb--;
                stringBuilder.insert(0, addResult);
            }
            if (b == 1) {
                stringBuilder.insert(0, 1);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}