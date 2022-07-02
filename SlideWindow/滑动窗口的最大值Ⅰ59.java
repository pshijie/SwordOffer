import java.util.Deque;
import java.util.LinkedList;

/**
 * @author psj
 * @date 2022/7/2 9:47
 * @File: 滑动窗口的最大值Ⅰ59.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
// 给定一个数组nums和滑动窗口的大小k，请找出所有滑动窗口里的最大值

public class 滑动窗口的最大值Ⅰ59 {
    // 单调递减队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        // 存储每一个窗口的最大值
        int[] result = new int[nums.length - k + 1];
        int index = 0; // result的下标

        // Ⅰ、形成初始窗口(即遍历nums中前k个数，看哪些可以假如到队列中)
        for (int i = 0; i < k; i++) {
            // 如果队列不为空
            // 如果当前遍历的nums[i]大于队列尾部值，删除队尾元素
            // 知道遇到队列中较大的值或者队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            // 将当前遍历的nums[i]假如到队列中
            deque.addLast(nums[i]);
        }
        // 将初始窗口的最大值加入到结果集中
        result[index++] = deque.peekFirst();

        // Ⅱ、开始移动窗口(即同时移动左边界和右边界)
        // i可以视为右边界，i-k可以视为左边界
        for (int i = k; i < nums.length; i++) {
            // 1.移动左边界
            // deque.peekFirst()为当前队列最大的值
            // 如果要移除的左边界的值正好为该最大值
            // 除了移除左边界元素，还要将队列中的该元素移除(即队首元素)
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            // 2.移动右边界
            // 如果队列不为空
            // 如果当前遍历的nums[i]大于队列尾部值，删除队尾元素
            // 知道遇到队列中较大的值或者队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            result[index++] = deque.peekFirst(); // 将当前窗口的最大值加入到结果集中
        }

        return result;
    }
}
