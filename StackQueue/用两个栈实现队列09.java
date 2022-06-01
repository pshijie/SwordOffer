import java.util.Stack;

/**
 * @author psj
 * @date 2022/6/1 9:18
 * @File: 用两个栈实现队列09.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
// 分别完成在队列尾部插入整数和在队列头部删除整数的功能(若队列中没有元素，deleteHead操作返回-1)

public class 用两个栈实现队列09 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public 用两个栈实现队列09() {
        stack1 = new Stack<>();  // 将s1看作是队列
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        // 将s1看作是队列，直接在s1的栈顶插入，队列的顺序是s1的栈底到栈顶
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果要被删除元素的队列为空,就返回-1
        if (stack1.empty()) {
            return -1;
        }
        // 当s1不为空时,将s1中所有元素导入s2中
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        // 此时s2的栈顶就是需要被删除的元素
        int result = stack2.pop();
        // 确定了要被删除的元素后,要将s2的剩余元素再次放回到s1队列中
        // 等下一次执行appendTail时能保持顺序不错乱
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return result;
    }
}
