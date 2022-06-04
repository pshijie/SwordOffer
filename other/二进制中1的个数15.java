/**
 * @author psj
 * @date 2022/6/4 8:58
 * @File: 二进制中1的个数15.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
// 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数

public class 二进制中1的个数15 {
    // 方法1:逐位运算
    public int hammingWeight_traverse(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;  // 判断数字n转换为二进制后的末尾是否为1
            n >>>= 1;  // 无符号右移
        }
        return result;
    }

    // 方法2:n&(n-1)
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result++;  // 每把最右侧的一个1变为0就将结果加上1
            n &= n - 1;  // 将n的二进制的最右边的数字1变为0
        }
        return result;
    }
}
