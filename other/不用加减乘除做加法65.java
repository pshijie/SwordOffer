/**
 * @author psj
 * @date 2022/7/5 9:24
 * @File: 不用加减乘除做加法65.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号

// tips：
//  在计算机系统中数值一律用补码来表示和存储
//  补码的优势：加法、减法可以统一处理(即CPU只有加法器)

public class 不用加减乘除做加法65 {
    // 两个数的二进制为的求和:
    // 假设两个数的当前二进制位为0和0或者0和1，则相加还是0或者1，相当于发生一次异或运算
    // 假设两个数的当前二进制位为1和1，则相加是0(但是存在一个进位)，相当于发生一次与运算，但是向左移一位
    // 所以两个数的当前位为a和b，则a+b转换为n+c
    // n=a⊕b c=a&b<<1
    public int add(int a, int b) {
        int sum = a ^ b;  // ^表示异或
        int carry = (a & b) << 1;  // &表示与
        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }
}
