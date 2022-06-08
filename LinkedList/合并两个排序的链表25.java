/**
 * @author psj
 * @date 2022/6/8 9:28
 * @File: 合并两个排序的链表25.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的

public class 合并两个排序的链表25 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode newList = new ListNode(-1);
        ListNode dummy = newList;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                newList.next = l2;
                l2 = l2.next;
                newList = newList.next;
            } else {
                newList.next = l1;
                l1 = l1.next;
                newList = newList.next;
            }
        }
        if (l1 != null) {
            newList.next = l1;
        }
        if (l2 != null) {
            newList.next = l2;
        }
        return dummy.next;
    }
}
