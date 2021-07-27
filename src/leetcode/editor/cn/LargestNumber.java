//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出："1"
// 
//
// 示例 4： 
//
// 
//输入：nums = [10]
//输出："10"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 109 
// 
// Related Topics 贪心 字符串 排序 
// 👍 746 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        int[] arr = {8308, 8308, 830};
        System.out.println(solution.largestNumber(arr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            if (nums.length == 1) return String.valueOf(nums[0]);
            String[] strNums = new String[nums.length];
            for (int i = 0; i < strNums.length; i++) {
                strNums[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strNums, (o1, o2) -> {
                if (o1.length() != o2.length()) {
                    String s = o2;
                    o2 += o1;
                    o1 += s;
                }
                return o2.compareTo(o1);
            });
            String result = "";
            if (Long.parseLong(strNums[0]) == 0l) return "0";
            for (int i = 0; i < strNums.length; i++) {
                result += strNums[i];
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}