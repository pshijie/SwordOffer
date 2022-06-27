import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/6/27 9:33
 * @File: 二叉树的深度Ⅰ55.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
// 输入一棵二叉树的根节点，求该树的深度。
// 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度

public class 二叉树的深度Ⅰ55 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1：后序遍历
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 加1是加上当前层数
        int result = Math.max(left, right) + 1;
        return result;
    }

    // 方法2：层次遍历
    public int maxDepth_level(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            // 此时遍历到一个新层
            result++;
            int n = queue.size();  // 需要提前记录，因为后续会改变
            // 将当前层的所有节点的左右孩子节点加入队列，然后移除该节点
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return result;
    }
}
