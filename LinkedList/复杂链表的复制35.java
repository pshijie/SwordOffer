import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/6/14 9:44
 * @File: 复杂链表的复制35.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/
// 请实现copyRandomList函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向下一个节点，还有一个random指针指向链表中的任意节点或者null

public class 复杂链表的复制35 {
    // 普通链表复制代码如下:
//    public Node copyRandomList_norm(Node head) {
//        Node cur = head;
//        Node dummy = new Node(-1);
//        Node pre = dummy;
//        while (cur != null) {
//            Node node = new Node(cur.val);
//            pre.next = node;
//            cur = cur.next;
//            pre = node;
//        }
//        return dummy.next;
//    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 方法1:使用HashMap
    public Node copyRandomList_map(Node head) {
        if (head == null) {
            return null;
        }
        // 相当于map的key存储原链表节点,map的value值存储新链表的节点
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 建立原节点->新节点的映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 构建新链表next和random指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 返回新链表的头节点
        return map.get(head);
    }

    // 方法2:拼接+拆分
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 拼接链表:在原链表的每个节点后复制一个相同的节点
        // 假设原链表为7->3->2,拼接后变为7->7->3->3->2->2
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        // 构建拼接链表中的新节点的random指向
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                // cur.random是原节点的random指向
                // 由于新节点肯定要指向新节点,所以需要指向的是新节点cur.random.next
                // 比如7->7(1)->3->3(1)->2->2(1)中7的random指向2,则7(1)要指向2(1)不是2
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 将拼接链表进行拆分
        Node result = head.next;
        Node moveNew = head.next;  // 拆分后的新链表当前头节点
        Node pre = head;  // 拆分后原链表当前头节点
        while (moveNew.next != null){
            pre.next = pre.next.next;
            moveNew.next = moveNew.next.next;
            pre = pre.next;
            moveNew = moveNew.next;
        }
        // 当跳出上述循环后,新链表的尾指针已经指向null了,原链表的还没有
        // 所以单独需要下面代码处理
        pre.next = null;
        return result;
    }
}
