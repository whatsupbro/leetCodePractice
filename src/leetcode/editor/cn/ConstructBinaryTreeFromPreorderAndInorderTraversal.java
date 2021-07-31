//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1136 👎 0

package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        int[] arr1 = {3, 9, 20, 15, 7};
        int[] arr2 = {9, 3, 15, 20, 7};
        new Codec().serialize(solution.buildTree(arr1, arr2));
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, inorder, 0, 0, preorder.length);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int len) {
            if (len <= 0) return null;
            TreeNode root = new TreeNode(preorder[preStart]);
            if (len == 1) return root;
            int index = inStart;
            while (inorder[index] != preorder[preStart]) index++;
            int leftLen = index - inStart;
            root.left = buildTree(preorder, inorder, preStart + 1, inStart, leftLen);
            root.right = buildTree(preorder, inorder, preStart + leftLen + 1, index + 1, len - 1 - leftLen);
            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}