package leetcode.editor.cn;

/**
 * @description:
 * @author: miao
 * @create: 2021-07-31
 **/

public class offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre, head;

        public Node treeToDoublyList(Node root) {
            if (root == null) return root;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        public void dfs(Node node) {
            if (node == null) return;
            dfs(node.left);
            if (pre != null) pre.right = node;
            else head = node;
            node.left = pre;
            pre = node;
            dfs(node.right);
        }
    }
}
