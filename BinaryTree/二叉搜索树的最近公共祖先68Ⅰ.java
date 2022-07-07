/**
 * @author psj
 * @date 2022/7/7 9:37
 * @File: 二叉搜索树的最近公共祖先68Ⅰ.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
// 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先

public class 二叉搜索树的最近公共祖先68Ⅰ {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1：迭代
    // 因为树是二叉搜索树，所以可以根据p、q值与root值的比较判断p和q在root的哪个子树上
    public TreeNode lowestCommonAncestor_iter(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // 如果p和q都在root的右子树中
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
                // 如果p和q都在root的左子树中
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
                // 在不同的子树则最近公共祖先就是root
            } else {
                break;
            }
        }
        return root;

    }

    // 方法2：递归
    // lowestCommonAncestor的本意就是找到在以root为根节点的树，p和q的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

}