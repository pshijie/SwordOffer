import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/6/27 9:13
 * @File: 二叉搜索树的第k大节点54.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
// 给定一棵二叉搜索树，请找出其中第k大的节点的值

public class 二叉搜索树的第k大节点54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1：中序遍历整棵树
    List<Integer> list;

    public int kthLargest_all(TreeNode root, int k) {
        list = new LinkedList<>();
        inOrder_all(root);
        return list.get(list.size() - k);
    }

    public void inOrder_all(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    // 方法2：倒序中序遍历(找到节点便停止遍历)
    int k, result;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        //当root为空或者已经找到了result时直接返回
        if (root == null || k == 0) {
            return;
        }
        inOrder(root.right);
        // 此时遍历当前节点
        k--;
        if (k == 0) {
            result = root.val;
            return;  // 找到后没有必要再遍历
        }
        inOrder(root.left);
    }
}
