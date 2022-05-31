import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/5/31 9:53
 * @File: 从尾到头打印链表06.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值(用数组返回)

public class 从尾到头打印链表06 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 方法1:辅助空间
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] result = new int[list.size()];
        for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
            result[j] = list.get(i);
        }
        return result;
    }

    // 方法2:递归
    List<Integer> tmp = new ArrayList<>();

    public int[] reversePrint_recursion(ListNode head) {
        recursion(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    public void recursion(ListNode node) {
        if (node == null) {
            return;
        }
        recursion(node.next);
        // 写在递归代码后面,这样tmp中保存的数据为倒序
        tmp.add(node.val);
    }
}
