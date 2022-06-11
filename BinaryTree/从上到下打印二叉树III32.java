import java.util.*;

/**
 * @author psj
 * @date 2022/6/11 9:28
 * @File: 从上到下打印二叉树III32.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推

public class 从上到下打印二叉树III32 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 方法1:使用双端队列
    public List<List<Integer>> levelOrder_deque(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<Integer> temp = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                // 如果需要从左到右遍历,则依次插入temp尾部
                // 如果需要从右到左遍历,则依次插入temp头部
                if (flag) {
                    temp.addLast(cur.val);
                } else {
                    temp.addFirst(cur.val);
                }
                // 加入到queue的节点还是先加左再加右
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            flag = !flag;
            result.add(new LinkedList<>(temp));
        }
        return result;
    }

    // 方法2:使用Collections.reverse
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            if (result.size() % 2 ==1){
                Collections.reverse(temp);
            }
            result.add(temp);
        }
        return result;
    }
}