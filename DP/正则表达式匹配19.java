/**
 * @author psj
 * @date 2022/6/6 9:07
 * @File: 正则表达式匹配19.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
// 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配

public class 正则表达式匹配19 {
    // 重点在于从p的末尾开始匹配,假设len(s)=n,len(p)=m
    // 1.当p的最后一个字符为正常字符:
    //   ① s[n-1]=p[m-1],继续观察s[0...n-2]和p[0...m-2]
    //   ② s[n-1] != p[m-1],不匹配
    // 2.当p的最后一个字符为'.':
    //   直接观察s[0...n-2]和p[0...m-2]
    // 3.当p的最后一个字符为'*',表示p[m-2]=c可以重复0次或者多次(视为一个整体c*)
    //   ① s[n-1]!=c,意味这p的最后两个字符'*'和c没用,需要判断s[0...n-1]和p[0...m-3]是否匹配
    //   ② s[n-1]=c,表示p的'*'可以匹配s[n-1],因为'*'还可以匹配,所以继续判断s[0...n-2]和p[0...m-1]是否匹配
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        // dp[i][j]表示s的前i个字符和p的前j个字符能否匹配
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 非空串和空正则串肯定不匹配,所以dp[i][0]=false
                // 空串和空正则串匹配,所以dp[0][0]=true
                // 下面判断是空正则串的情况
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    // 最后一个字符不为'*'
                    if (p.charAt(j - 1) != '*') {
                        // 考虑情况1和2
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                            // 对于情况1中的②,因为boolean数组默认为false,所以可以不用显示写出
                        }
                    } else {
                        // 考虑情况3
                        // 对于下面两种情况,并不是if else的关系,而是满足其中一种都可
                        // 对于*,选择不匹配
                        if (j>=2){
                            dp[i][j] |= dp[i][j-2];
                        }
                        // 对于*,选择匹配
                        if (i >= 1 && j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}
