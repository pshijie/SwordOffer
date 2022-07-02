/**
 * @author psj
 * @date 2022/7/2 9:30
 * @File: 左旋转字符串Ⅱ58.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
// 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
// 请定义一个函数实现字符串左旋转操作的功能

public class 左旋转字符串Ⅱ58 {
    // 方法1：字符串拼接
    public String reverseLeftWords_append(String s, int n) {
        StringBuilder result = new StringBuilder();
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length());
        return result.append(s2).append(s1).toString();
    }

    // 方法2:取余
    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            result.append(s.charAt(i % s.length()));
        }
        return result.toString();
    }

}
