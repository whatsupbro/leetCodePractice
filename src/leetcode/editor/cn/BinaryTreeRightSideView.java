//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 492 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;
            result.add(root.val);

            List<Integer> rightResult = rightSideView(root.right);
            result.addAll(rightResult);

            List<Integer> leftResult = rightSideView(root.left);

            if (leftResult.size() >= result.size()) {
                for (int i = rightResult.size(); i < leftResult.size(); i++) {
                    result.add(leftResult.get(i));
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}