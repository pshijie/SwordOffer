/**
 * @author psj
 * @date 2022/7/5 9:17
 * @File: 求1到n的累加和64.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/qiu-12n-lcof/
// 求 1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）

public class 求1到n的累加和64 {
    // 方法1:公式
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }

    // 方法2:递归
    public int sumNums_recursion(int n) {
        if (n == 1) {
            return 1;
        }
        n += sumNums_recursion(n - 1);
        return n;
    }


}
