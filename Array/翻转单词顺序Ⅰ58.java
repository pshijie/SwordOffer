import java.util.Arrays;
import java.util.Collections;

/**
 * @author psj
 * @date 2022/7/1 9:43
 * @File: 翻转单词顺序Ⅰ58.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理

public class 翻转单词顺序Ⅰ58 {
    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            // 假设原字符串存在连续多个的空字符，在split的时候会将空字符""(不是空格)也分隔出来视为单词
            if (split[i] == ""){
                continue;
            }
            result.append(split[i] + " ");
        }
        return result.toString().trim();
    }

}
