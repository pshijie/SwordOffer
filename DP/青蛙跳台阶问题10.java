/**
 * @author psj
 * @date 2022/6/1 9:45
 * @File: 青蛙跳台阶问题10.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法

public class 青蛙跳台阶问题10 {
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
