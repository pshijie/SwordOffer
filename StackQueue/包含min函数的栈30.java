import java.util.Stack;

/**
 * @author psj
 * @date 2022/6/10 9:26
 * @File: 包含min函数的栈30.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
// 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)

public class 包含min函数的栈30 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public 包含min函数的栈30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty()) {
            if (x <= stack2.peek()) {
                stack2.push(x);
            }
        } else {
            stack2.push(x);
        }
    }

    public void pop() {
        int popNum = stack1.pop();
        if (popNum == stack2.peek()) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
