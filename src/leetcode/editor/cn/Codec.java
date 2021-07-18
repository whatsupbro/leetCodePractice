package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 序列化 反序列化 二叉树
 * @author: miao
 * @create: 2021-03-26
 **/

public class Codec {
    public static void main(String[] args) {
        //new offer.Solution32().levelOrder2(new offer.Codec().deserialize("[1,2,3,null,null,4,5]"));
        new Codec().serialize(new Codec().deserialize("[1,2,3,null,null,4,5]"));
        //new offer.Codec().serialize(new offer.Codec().deserialize("[1,2]"));
    }

    //官方解法 我自己写的代码太冗余了
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            } else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    //官方解法
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>() {{
            add(root);
        }};
        int i = 1;
        while (!queue.isEmpty() && i < vals.length) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (i < vals.length && !vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}
