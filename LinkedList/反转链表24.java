/**
 * @author psj
 * @date 2022/6/8 9:04
 * @File: 反转链表24.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/
// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点

public class 反转链表24 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 方法1:迭代
    public ListNode reverseList_iterate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 方法2:递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 此时已经将除当前节点head以外剩余的节点反转了,并返回新的头节点
        ListNode newHead = reverseList(head.next);
        // 此时需要将head的下一个节点的next指针指向head即可
        head.next.next = head;
        // 此时head作为新链表的尾节点,next指针需要置为null
        head.next = null;
        return newHead;
    }
}