/**
 * @author psj
 * @date 2022/6/28 9:23
 * @File: 平衡二叉树Ⅱ55.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树

public class 平衡二叉树Ⅱ55 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左右子树高度差
        int subDepth = Math.abs(depth(root.left) - depth(root.right));
        return subDepth <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 计算当前树的高度(取左/右子树中的最大高度)
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 加1表示当前根节点也算一层
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
