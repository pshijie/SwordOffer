/**
 * @author psj
 * @date 2022/6/8 8:51
 * @File: 链表中倒数第k个节点22.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点

public class 链表中倒数第k个节点22 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        int moveStep = k - 1;
        while (temp != null && moveStep != 0) {
            temp = temp.next;
            moveStep--;
        }
        while (temp.next != null) {
            head = head.next;
            temp = temp.next;
        }
        return head;
    }
}
