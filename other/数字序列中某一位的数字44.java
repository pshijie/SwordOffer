/**
 * @author psj
 * @date 2022/6/21 9:59
 * @File: 数字序列中某一位的数字44.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
// 数字以0123456789 10 11 12 13 14 15…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4
// 请写一个函数，求任意第n位对应的数字
public class 数字序列中某一位的数字44 {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        // 表示第n位数对应的位数(比如110的位数就是3)
        int digit = 1;
        // 表示每位数的所有数字的数总和(比如位数3的数有100-999,共有900=100*9个数,count=900*3=2700)
        // 这里的9是位数位1时的1-9这9个数字
        long count = 9;
        long start = 1;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;  // 比如2位数的start就是10,三位数的就是100
            count = digit * (start * 9);
        }
        // 表示n在当前位数的集合中的第几个数字
        long num = start + (n - 1) / digit;
        // 确定所求数位在num的哪一数位,比如num=123,确定是1或2或3
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
