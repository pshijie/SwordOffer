import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/6/14 9:15
 * @File: 二叉树中和为某一值的路径34.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
// 给你二叉树的根节点 root和一个整数目标和targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。

public class 二叉树中和为某一值的路径34 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        result = new LinkedList<>();
        this.target = target;
        if (root == null) {
            return result;
        }
        int curSum = 0;
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(root, temp, curSum);
        return result;
    }

    public void dfs(TreeNode node, LinkedList<Integer> temp, int curSum) {
        if (node == null) {
            return;
        }
        // 添加
        temp.add(node.val);
        curSum += node.val;
        if (curSum == target && node.left == null && node.right == null) {
            result.add(new LinkedList<>(temp));
        }
        dfs(node.left, temp, curSum);
        dfs(node.right, temp, curSum);
        // 移除
        curSum -= node.val;  // 该行代码不加也能通过测试
        temp.removeLast();
    }
}
