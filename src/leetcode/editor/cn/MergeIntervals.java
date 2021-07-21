//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1016 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] merge(int[][] intervals) {
            List<int[]> result = new ArrayList<>();
            //排序 按照第一个元素大小排序 如果第一个元素相等 按照第二个元素排序
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            });
            int cur = 0;
            while (cur < intervals.length) {
                int[] arr = new int[2];
                //区间的左右边界
                int left = intervals[cur][0];
                int right = intervals[cur][1];
                //确定可以合并的区间
                while (cur < intervals.length - 1 && intervals[cur + 1][0] >= left && intervals[cur + 1][0] <= right) {
                    cur++;
                    //右区间取最大数
                    right = Math.max(right, intervals[cur][1]);
                }
                arr[0] = left;
                arr[1] = right;
                result.add(arr);
                cur++;
            }
            return result.toArray(new int[result.size()][]);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}