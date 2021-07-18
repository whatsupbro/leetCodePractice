//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。 
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 215 👎 0

package leetcode.editor.cn;

public class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        Solution solution = new FindMinimumTimeToFinishAllJobs().new Solution();
        int[] jobs = {1, 2, 4, 7, 8};
        int num = 2;
        solution.minimumTimeRequired(jobs, num);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] jobs1;
        private int ans = Integer.MAX_VALUE;

        public int minimumTimeRequired(int[] jobs, int k) {
            jobs1 = jobs;
            int[] all = new int[k];
            dfs(0, 0, all, 0);
            return ans;
        }
        /**
         * @param curJ 当前的分配到了第几个工作
         * @param curK 当前分配到了第几个工人
         * @param allocate 每个工人分配工作的累计数量
         * @param max 当前的最大值
         * */
        public void dfs(int curJ, int curK, int[] allocate, int max) {
            if (max > ans) return;
            if (curJ == jobs1.length) {
                ans = max;
                return;
            }
            //将任务优先分配给「空闲工人」
            if (curK < allocate.length) {
                allocate[curK] = jobs1[curJ];
                dfs(curJ + 1, curK + 1, allocate, Math.max(max, allocate[curK]));
                allocate[curK] = 0;
            }
            for (int i = 0; i < curK; i++) {
                allocate[i] += jobs1[curJ];
                dfs(curJ + 1, curK, allocate, Math.max(max, allocate[i]));
                allocate[i] -= jobs1[curJ];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}