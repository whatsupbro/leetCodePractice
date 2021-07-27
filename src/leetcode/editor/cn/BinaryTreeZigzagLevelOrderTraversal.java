//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 479 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
        solution.zigzagLevelOrder(new Codec().deserialize("[]"));
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            int layerNums = 1;
            int nextLayerNums = 0;
            int layer = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                List<Integer> list = new ArrayList<>(layerNums);
                for (int i = 0; i < layerNums; i++) {
                    TreeNode node = queue.poll();
                    if (layer % 2 == 0) {
                        list.add(0, node.val);
                    } else {
                        list.add(node.val);
                    }
                    if (node.left != null) {
                        nextLayerNums++;
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        nextLayerNums++;
                        queue.add(node.right);
                    }
                }
                layer++;
                layerNums = nextLayerNums;
                nextLayerNums = 0;
                result.add(list);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}