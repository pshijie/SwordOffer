/**
 * @author psj
 * @date 2022/6/3 9:17
 * @File: 剪绳子14.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/jian-sheng-zi-lcof/
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1]
// 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？

public class 剪绳子Ⅰ14 {
    // 方法1:贪心
    // ① 当所有绳段长度相等时，乘积最大
    // ② 最优的绳段长度为3
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int m = n % 3;
        int k = n / 3;
        if (m == 0) {
            return (int) Math.pow(3, k);
        }
        if (m == 1) {
            return (int) Math.pow(3, k - 1) * 4;
        }

        return (int) Math.pow(3, k) * 2;
    }

    // 方法2:动态规划
    public int cuttingRope_dp(int n) {
        // dp[i]表示长度为i时的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i ; j++) {
                // dp[i]表示不减
                // j*dp[i-j]表示减去第一段，即第一段长度 * 剩下长度的最大值
                // j * (i - j)表示剪第一段，剩余的不剪，即第一段长度 * 剩下的长度
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}