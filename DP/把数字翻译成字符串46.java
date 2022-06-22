/**
 * @author psj
 * @date 2022/6/22 9:36
 * @File: 把数字翻译成字符串46.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法

public class 把数字翻译成字符串46 {
    // 假设x1x2...x(i-2)构成的整数翻译数量为f(i-2)
    // 假设x1x2...x(i-1)构成的整数翻译数量为f(i-1)
    // 当x(i-1)xi被整体翻译时，x1x2...x(i-2)x(i-1)xi=x1x2...x(i-2) + x(i-1)xi,即的翻译数量为f(i-2)
    // 当xi被单独翻译时，x1x2...x(i-2)x(i-1)xi=x1x2...x(i-1) + xi,的翻译数量为f(i-1)
    // 上述的关键点在于x(i-1)xi能否被整体翻译
    public int translateNum(int num) {
        String s = String.valueOf(num);
        // dp[i]表示以num[i]结尾的数字可以被翻译的数量
        int[] dp = new int[s.length()+1];
        // dp[0]本身没有意义,是因为dp[2]=dp[0]+dp[1]推导而来(前两位组成的数字在[10,25]区间内时,dp[2]=2)
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            // 将num[i-2]和num[i-1]组成的整数提取出来进行判断
            String temp = s.substring(i - 2, i);
            // 如果构成的整数在[10,25]范围内,说明组成的整数可以被整体翻译
            // 此时可以选择将其整体翻译,也可以选择单独翻译num[i-1]
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
                dp[i] = dp[i-1] + dp[i-2];
            }else{
                // 此时只能单独翻译
                dp[i] = dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
