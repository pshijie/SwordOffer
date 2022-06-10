/**
 * @author psj
 * @date 2022/6/10 9:13
 * @File: 对称的二叉树28.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
// 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的

public class 对称的二叉树28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    // 判断根节点为left的树和根节点为right的树是否对称
    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 执行到该步说明left或right其中有一个为null
        if (left == null || right == null) {
            return false;
        }
        // 执行到该步说明left和right都不为null
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
