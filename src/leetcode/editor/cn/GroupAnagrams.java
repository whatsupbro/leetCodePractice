//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 774 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> resultList = new ArrayList<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortStr = new String(chars);
                if (hashMap.containsKey(sortStr)) {
                    resultList.get(hashMap.get(sortStr)).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    resultList.add(list);
                    hashMap.put(sortStr, resultList.size() - 1);
                }
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}