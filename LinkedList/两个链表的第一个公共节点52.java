import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/6/25 9:35
 * @File: 两个链表的第一个公共节点52.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
// 输入两个链表，找出它们的第一个公共节点

public class 两个链表的第一个公共节点52 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 方法1:使用Set集合(就是找到第一个相同的节点)
    public ListNode getIntersectionNode_set(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        // 把链表A的节点加入集合
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        // 遍历链表B的节点,找到第一个出现在集合中的节点
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // 方法2:统计两个链表长度
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int count1 = 0;
        int count2 = 0;
        while (temp1 != null) {
            temp1 = temp1.next;
            count1++;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            count2++;
        }

        temp1 = headA;
        temp2 = headB;
        int moveNum = Math.abs(count1 - count2);
        if (count1 > count2) {
            while (moveNum != 0) {
                temp1 = temp1.next;
                moveNum--;
            }
        } else {
            while (moveNum != 0) {
                temp2 = temp2.next;
                moveNum--;
            }
        }
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    // 方法3:双指针遍历完A再去遍历B
    // 假设第一个公共节点为node，公共部分长度为c，a为链表A的长度，b为链表B的长度
    // 指针A先遍历完链表headA，再开始遍历链表headB，当走到node时，共走步数为：a+(b-c)
    // 指针B先遍历完链表headB，再开始遍历链表headA，当走到node时，共走步数为：b+(a-c)
    // 可以明显知道a+(b-c)=b+(a-c),即按照上述过程是可以同时走到第一个公共节点的
    public ListNode getIntersectionNode_trick(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

}
