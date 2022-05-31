/**
 * @author psj
 * @date 2022/5/31 10:04
 * @File: buildTree.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
// 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字

public class 重建二叉树07 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        int index = 0;
        for (int i = iStart; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - iStart;
        root.left = buildTree(preorder, pStart + 1, pStart + leftSize, inorder, iStart, index - 1);
        root.right = buildTree(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }
}
