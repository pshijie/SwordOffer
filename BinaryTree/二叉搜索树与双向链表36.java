/**
 * @author psj
 * @date 2022/6/16 8:17
 * @File: 二叉搜索树与双向链表36.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向

public class 二叉搜索树与双向链表36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 构建每个节点的双向关系(除了head和tail节点)
        dfs(root);
        // 因为pre是全局变量,指向到该行代码时已经指向尾节点了
        // 此时完成循环链表的构建(即完成head和tail的双向关系的构建)
        pre.right = head;
        head.left = pre;

        return head;
    }

    // 在进行中序遍历的同时,将构建每一个节点的双向关系
    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur
        // 当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        if (pre == null) {
            head = cur;
        } else {  // 当pre!=null时，cur左侧有节点pre
            // 构建pre和cur的指向关系:pre.right = cur
            pre.right = cur;
        }
        // 构建pre和cur的指向关系:cur.left = pre
        cur.left = pre;
        // 相当于移动到链表的下一个节点
        pre = cur;

        // 可以认为cur=cur.right
        dfs(cur.right);
    }
}
