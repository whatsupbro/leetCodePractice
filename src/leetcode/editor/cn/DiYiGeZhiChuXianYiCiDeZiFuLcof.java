//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 124 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        solution.firstUniqChar("leecode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {
            Queue<Character> setOnce = new LinkedList<>();
            Set<Character> setTwice = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (setOnce.contains(c)) {
                    setOnce.remove(c);
                    setTwice.add(c);
                } else if (!setTwice.contains(c)) {
                    setOnce.add(c);
                }
            }
            if (setOnce.isEmpty()) {
                return ' ';
            } else {
                return setOnce.stream().findFirst().get();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}