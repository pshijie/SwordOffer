import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/6/24 9:32
 * @File: 第一个只出现一次的字符50.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
// 在字符串s中找出第一个只出现一次的字符。如果没有返回一个单空格。s只包含小写字母

public class 第一个只出现一次的字符50 {
    public char firstUniqChar(String s) {
        // 有序Hash表
        // value值没有必要存储出现次数,出现就置为false即可
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> c : map.entrySet()) {
            // 如果value是true，则返回对应的key
            if (c.getValue()){
                return c.getKey();
            }
        }
        return ' ';
    }
}
