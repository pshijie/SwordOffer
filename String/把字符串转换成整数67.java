/**
 * @author psj
 * @date 2022/7/7 9:21
 * @File: 把字符串转换成整数67.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
// 写一个函数StrToInt，实现把字符串转换成整数这个功能

public class 把字符串转换成整数67 {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int result = 0;
        // 用于判断result是否超过Int类型的最大值
        int border = Integer.MAX_VALUE / 10;  // Integer.MAX_VALUE=2147483647
        int sign = 1;  // 符号位
        int start = 1;  // 开始变量的位置
        if (c[0] == '-') {
            sign = -1;
        } else if (c[0] != '+') {  // 如果字符串首位不是符号位，则从首位开始遍历
            start = 0;
        }
        for (int j = start; j < c.length; j++) {
            // 出现非数字则结束遍历
            if (c[j] < '0' || c[j] > '9') {
                break;
            }
            // 此时result越界
            if (result > border || result == border && c[j] > '7') {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 之所以上面Integer.MAX_VALUE / 10,是因为这里需要乘以10
            // 并且除了判断作为结果出现的result，还要判断作为乘数出现的result
            // 所以上述判断越界是判断两个条件
            result = result * 10 + (c[j] - '0');
        }
        return sign * result;
    }
}
