import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/6/10 8:54
 * @File: 二叉树的镜像27.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/
// 请完成一个函数，输入一个二叉树，该函数输出它的镜像

public class 二叉树的镜像27 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1:递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 相对于交换两个数字
        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = mirrorTree(root.left);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    // 方法2:层次遍历
    public TreeNode mirrorTree_level(TreeNode root) {
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            // 每次将节点加入队列还是从左节点开始加入
            // 因为后续会把加入的左右节点进行交换
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }
}
