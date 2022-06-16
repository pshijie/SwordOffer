import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/6/16 9:07
 * @File: 序列化二叉树37.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
// 请实现两个函数，分别用来序列化和反序列化二叉树。
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列/反序列化算法执行逻辑
// 只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

public class 序列化二叉树37 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 采用层次遍历树,输出字符串
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.append(node.val + ",");
                // 这里因为需要空节点,所以不需要对左右孩子节点判空
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.append("null,");
            }
        }
        // 删除最后一个字符,即","
        result.deleteCharAt(result.length() - 1);
        result.append("]");
        return result.toString();
    }

    // 采用层次遍历字符串,输出树
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        // 删除开头的"["和结尾的"]"
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;  // i表示序列化后的字符串中的下标值(从1开始是因为已经将root加入到树中)
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            // 往字符串下一个位置遍历
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;

        }
        return root;
    }
}
