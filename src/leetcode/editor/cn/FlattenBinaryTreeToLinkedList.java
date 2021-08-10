//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 
// 👍 869 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Pattern;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        //Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        //solution.flatten(new Codec().deserialize("[1,null,5,null,6]"));
        String s = "2//13hvofi46.56WFE34,5";
        String pattern = "/[A-Z]/";
        String[] arr = s.split(pattern);
        System.out.println(arr);
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
        public void flatten1(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    node.right = node.left;
                    TreeNode cur = node.left;
                    node.left = null;
                    node = cur;
                } else if (!stack.isEmpty()) {
                    TreeNode cur = stack.pop();
                    node.right = cur;
                    node = cur;
                } else {
                    break;
                }
            }
        }

        public void flatten(TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                //找到左子树的最右边节点
                TreeNode leftTree = node.left;
                if (leftTree != null) {
                    while (leftTree.right != null && leftTree.right != null) {
                        if (leftTree.right != null) leftTree = leftTree.right;
                        else if (leftTree.left != null) leftTree = leftTree.left;
                    }
                    leftTree.right = node.right;
                    node.right = node.left;
                    node.left = null;
                    node = node.right;
                } else {
                    node = node.right;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}