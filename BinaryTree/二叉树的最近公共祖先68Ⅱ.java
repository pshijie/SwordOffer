/**
 * @author psj
 * @date 2022/7/7 10:08
 * @File: 二叉树的最近公共祖先68Ⅱ.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
public class 二叉树的最近公共祖先68Ⅱ {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 该函数的含意不同于68Ⅰ，它是找到p和q所在的子树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 树为空的时候
        if (root == null) {
            return null;
        }
        // 如果root为p或q中的一个，则两个点的最近公共祖先就是root
        if (root == p || root == q) {
            return root;
        }
        // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果在左子树中p和q都找不到，则p和q一定都在右子树中
        // 右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        if (left == null) {
            return right;
            // 与上同理
        } else if (right == null) {
            return left;
            // 当left和right均不为空时，说明p、q节点分别在root两侧, 最近公共祖先即为root
        } else {
            return root;
        }
    }
}
