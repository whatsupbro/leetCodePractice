//存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。 
//
// 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui
// 和 vi 在 nums 中相邻。 
//
// 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i]
//, nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。 
//
// 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。 
//
// 
//
// 示例 1： 
//
// 
//输入：adjacentPairs = [[2,1],[3,4],[3,2]]
//输出：[1,2,3,4]
//解释：数组的所有相邻元素对都在 adjacentPairs 中。
//特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
// 
//
// 示例 2： 
//
// 
//输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
//输出：[-2,4,1,-3]
//解释：数组中可能存在负数。
//另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
// 
//
// 示例 3： 
//
// 
//输入：adjacentPairs = [[100000,-100000]]
//输出：[100000,-100000]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// adjacentPairs.length == n - 1 
// adjacentPairs[i].length == 2 
// 2 <= n <= 105 
// -105 <= nums[i], ui, vi <= 105 
// 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums 
// 
// Related Topics 数组 哈希表 
// 👍 52 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        Solution solution = new RestoreTheArrayFromAdjacentPairs().new Solution();
        int[][] data = {{4, -2}, {1, 4}, {-3, 1}};
        solution.restoreArray(data);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] restoreArray(int[][] adjacentPairs) {
            if (adjacentPairs.length == 1) return adjacentPairs[0];
            HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
            for (int[] pair : adjacentPairs) {
                hashMap.putIfAbsent(pair[0], new ArrayList<>());
                hashMap.putIfAbsent(pair[1], new ArrayList<>());
                hashMap.get(pair[0]).add(pair[1]);
                hashMap.get(pair[1]).add(pair[0]);
            }
            int start = 0;
            for (Map.Entry<Integer, ArrayList<Integer>> entry : hashMap.entrySet()) {
                if (entry.getValue().size() == 1) {
                    start = entry.getKey();
                    break;
                }
            }
            int[] re = new int[adjacentPairs.length + 1];
            re[0] = start;
            for (int i = 1; i < re.length; i++) {
                if (hashMap.containsKey(hashMap.get(start).get(0))) {
                    re[i] = hashMap.get(start).get(0);
                } else {
                    re[i] = hashMap.get(start).get(1);
                }
                hashMap.remove(start);
                start = re[i];
            }
            return re;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}