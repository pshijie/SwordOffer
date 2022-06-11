import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/6/11 8:58
 * @File: 从上到下打印二叉树Ⅰ32.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
// 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印

public class 从上到下打印二叉树Ⅰ32 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.add(root);
        list.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                list.add(cur.left.val);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                list.add(cur.right.val);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
