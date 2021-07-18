package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1646 👎 0


import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        solution.generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        ArrayList<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs("", n, n);
            return ans;
        }

        public void dfs(String s, int left, int right) {
            if (right == 0 && left == 0) {
                ans.add(s);
                return;
            }
            if (left > right)
                return;

            if (right > 0)
                dfs(s + ")", left, right - 1);
            if (left > 0)
                dfs(s + "(", left - 1, right);
        }

        public List<String> generateParenthesis1(int n) {
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            ArrayList<String> list0 = new ArrayList<>();
            list0.add("");
            ans.add(list0);
            ArrayList<String> list1 = new ArrayList<>();
            list1.add("()");
            ans.add(list1);
            for (int i = 2; i <= n; i++) {
                ArrayList<String> cur = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    ArrayList<String> One = ans.get(j);
                    ArrayList<String> two = ans.get(i - j - 1);
                    for (String s1 : One) {
                        for (String s2 : two) {
                            String s = "(" + s1 + ")" + s2;
                            cur.add(s);
                        }
                    }

                }
                ans.add(cur);
            }

            return ans.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}