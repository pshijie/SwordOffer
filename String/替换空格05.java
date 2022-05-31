/**
 * @author psj
 * @date 2022/5/31 9:27
 * @File: 替换空格05.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
// 请实现一个函数，把字符串s中的每个空格替换成"%20"

public class 替换空格05 {
    // 方法1:直接使用API
    public String replaceSpace_api(String s) {
        return s.replaceAll(" ", "%20");
    }
    // 方法2:使用StringBuilder
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' '){
                result.append("%20");
            }else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
