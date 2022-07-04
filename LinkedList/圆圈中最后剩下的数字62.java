import java.util.LinkedList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/4 9:16
 * @File: 圆圈中最后剩下的数字62.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
// 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字(删除后从下一个数字开始计数)
// 求出这个圆圈里剩下的最后一个数字

public class 圆圈中最后剩下的数字62 {
    // 方法1:单向链表
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            // 注意是对当前链表的长度进行取余，不是对原始的长度n取余
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    // 方法2:递归
    public int lastRemaining_recrsion(int n, int m) {
        // index表示最后剩余的元素在当前剩余数组中的下标
        // 比如到最后一轮只剩下一个元素，目标元素下标自然就是0
        // 而在上一轮中还剩两个数，目标元素在这两个元素中的下标为(0+m)%2=1(假设m=3)
        int index = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        // i表示当前数组长度
        for (int i = 2; i <= n; i++) {
            // 新的index = (当前index + m) % 上一轮剩余数字的个数
            index = (index + m) % i;
        }
        // 最后的index表示在初始数组中的下标位置
        return index;
    }
}
