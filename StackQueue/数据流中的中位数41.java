import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author psj
 * @date 2022/6/20 9:10
 * @File: 数据流中的中位数41.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
// 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值

public class 数据流中的中位数41 {
    // 之所以使用两个优先队列是因为中位数值只在意中间两个数，而两个优先队列的堆顶正好满足要求
    Queue<Integer> A, B;  // 分别表示小根堆和大根堆

    public 数据流中的中位数41() {
        A = new PriorityQueue<>();  // 小根堆保存数组中较大的一半数
        B = new PriorityQueue<>((x, y) -> (y - x));  // 大根堆保存数组中较小的一半数
    }

    public void addNum(int num) {
        // 当两个堆的个数不一样时(肯定是A堆要多)
        if (A.size() != B.size()) {
            // 先将num添加到大根堆B，然后将B的堆顶给A(保证B中最大的数要小于A中最小的数)
            A.add(num);
            B.add(A.poll());
        // 当两个堆的个数一样时
        } else {
            // 先将num添加到小根堆A，然后将A的堆顶给B(保证A中最小的数要大于B中最大的数)
            // 因为要保证A的数目大于B的数目
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        // 如果两个堆数目一样，则说明整个数组个数为偶数，取两个堆顶相加/2
        // 如果两个堆数目不一样，则说明整个数组个数为奇数，取数量较多的堆的堆顶元素(即A的堆顶元素)
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;  // 注意浮点运算
    }
}
