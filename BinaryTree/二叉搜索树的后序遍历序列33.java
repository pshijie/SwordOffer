/**
 * @author psj
 * @date 2022/6/13 9:25
 * @File: 二叉搜索树的后序遍历序列33.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同

public class 二叉搜索树的后序遍历序列33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // 判断区间在[i,j]的元素是否构成一颗二叉搜索树
    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        // 因为数组是后序遍历的结果,所以以当前区间最后一个元素j为标准
        // 找到第一个大于j位置的元素m,则[m,j-1]作为右子树部分(理论上的右子树)
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        // 此时需要判断[m,j-1]部分是否都要大于j元素，即判断是否满足BST的条件(右子树的节点都大于根节点)
        while (postorder[p] > postorder[j]) {
            p++;
        }
        // 当p==j时说明右子树的节点都大于j位置的节点
        // 此时继续判断左子树和右子树
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
