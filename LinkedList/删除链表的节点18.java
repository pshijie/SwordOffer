/**
 * @author psj
 * @date 2022/6/6 8:56
 * @File: 删除链表的节点18.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
// 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

public class 删除链表的节点18 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
