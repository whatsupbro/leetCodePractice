//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1423 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] arr = {2, 3, 6, 7};
        solution.combinationSum(arr, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 回溯 + 预排序 + 剪枝
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> re = combinationSum1(candidates, target, 0);
            return re;
        }

        /**
         * @param start 避免重复 之前的数不考虑
         */
        public List<List<Integer>> combinationSum1(int[] candidates, int target, int start) {
            List<List<Integer>> re = new ArrayList<>();
            //剪枝：1、当前的数组（从start开始）的最小数大于target；
            if (candidates.length > 0 && candidates[start] > target) return re;
            for (int i = start; i < candidates.length; i++) {
                //剪枝：2、当前的数大于target，后面的数全都不需要遍历；
                if (candidates[i] > target) break;
                if (candidates[i] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[i]);
                    re.add(list);
                } else {
                    List<List<Integer>> lists = combinationSum1(candidates, target - candidates[i], i);
                    if (lists != null) {
                        for (List<Integer> list : lists) {
                            list.add(candidates[i]);
                            re.add(list);
                        }
                    }
                }
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}