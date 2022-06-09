/**
 * @author psj
 * @date 2022/6/9 9:07
 * @File: 树的子结构26.java
 * @Software: IntelliJ IDEA
 */
// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
// B是A的子结构， 即A中有出现和B相同的结构和节点值

public class 树的子结构26 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) {
            return false;
        }
        // 如果A树的当前根节点与B树的当前根节点相等
        // 判断A树的左/右子树与B树的左/右子树结构是否一致
        if (A.val == B.val && helper(A.left, B.left) && helper(A.right, B.right)) {
            return true;
        }
        // 如果A树的当前根节点与B树的当前根节点不相等
        // 继续在A的子树中找到节点和B树根节点一样的节点
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean helper(TreeNode root1, TreeNode root2) {
        // 将匹配树遍历完毕
        if (root2 == null) {
            return true;
        }
        // 执行到该步说明匹配树为遍历完毕,被匹配树遍历完毕
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            // 两个树的当前根节点相同,
            // 继续判断root1的左/右子树与root2树的左/右子树结构是否一致
            return helper(root1.left, root2.left) && helper(root1.right, root2.right);
        } else {
            return false;
        }

    }
}
