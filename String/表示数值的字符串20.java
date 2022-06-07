import java.util.Stack;

/**
 * @author psj
 * @date 2022/6/7 9:11
 * @File: 表示数值的字符串20.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）

public class 表示数值的字符串20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 标记是否遇到数位、小数点、‘e’或'E'
        boolean isNum = false;
        boolean isDot = false;
        boolean iseOrE = false;
        // 将字符串头尾的空格删除
        char[] sArray = s.trim().toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            // 当前字符为数字
            if (sArray[i] >= '0' && sArray[i] <= '9') {
                isNum = true;
                // 当前字符为小数点
            } else if (sArray[i] == '.') {
                // 如果之前的字符已经存在小数点或者e/E,则该字符串表示错误
                if (isDot || iseOrE) {
                    return false;
                }
                isDot = true;
                // 当前字符为e/E
            } else if (sArray[i] == 'e' || sArray[i] == 'E') {
                // e/E前面必须有整数，且前面不能重复出现e/E
                if (!isNum || iseOrE) {
                    return false;
                }
                iseOrE = true;
                // 重置isNum，因为e/E之后也必须接上整数，
                // 防止出现123e或者123e+的非法情况
                isNum = false;
                // 当前字符为+/-
            } else if (sArray[i] == '-' || sArray[i] == '+') {
                // 正负号只可能出现在第一个位置，或者出现在e/E的后面一个位置
                if (i != 0 && sArray[i - 1] != 'e' && sArray[i - 1] != 'E') {
                    return false;
                }
            } else {
                return false;
            }

        }
        return isNum;
    }
}
