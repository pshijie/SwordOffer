import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/7/3 9:06
 * @File: 队列的最大值Ⅱ59.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/
// 请定义一个队列并实现函数max_value得到队列里的最大值，要求函数max_value、push_back 和 pop_front的均摊时间复杂度都是O(1)

public class 队列的最大值Ⅱ59 {
    // 单向队列,存储每个入队的值
    Queue<Integer> queue;
    // 构建一个单调不增的双向队列
    Deque<Integer> deque;

    class MaxQueue {

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            // deque的对头存储最大元素
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        // 该步的关键在于将双向队列中元素小于将入队元素的值全部移除
        public void push_back(int value) {
            // 将该值加入到普通队列
            queue.offer(value);
            // 如果此时要入队的元素大于deque的队尾元素则将队尾元素出队
            // 直到遇到相等或者较大的元素
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            // 将该值加入到双向队列
            deque.offerLast(value);
        }

        // 这一步的关键点在于如果普通队列出队的元素正好是双向队列的队首元素(即最大值)
        // 将双向队列中队首元素移除
        public int pop_front() {
            // 双向队列需要将该元素出队
            if (queue.isEmpty()) {
                return -1;
            }
            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.poll();
        }
    }
}
