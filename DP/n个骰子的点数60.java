/**
 * @author psj
 * @date 2022/7/3 9:35
 * @File: n个骰子的点数60.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率

public class n个骰子的点数60 {
    public double[] dicesProbability(int n) {
        // dp[i][j]表示投掷i个骰子点数和为j的次数
        // i的范围是[1,n]，j的范围是[n,6n]
        int[][] dp = new int[n + 1][6 * n + 1];

        // 初始化dp[i][1]=1,因为投1次出现1，2，3，4，5，6的次数都为1
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            // j的范围为[i,6i]
            for (int j = i; j <= 6 * i; j++) {
                // k的范围为1<=k<= 6 && j-k>=i-1
                // 即筛子的6个点数
                for (int k = 1; k <= 6; k++) {
                    // 假设当前有5(即i-1)个筛子，组成的和最少为5(即j-k)
                    if (j - k < i - 1) {
                        break;
                    }
                    // 比如dp[5][12] = dp[5][11]+dp[5][10]+...dp[5][6]
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        // n个筛子的组合为6^n
        double all = Math.pow(6, n);
        // n个筛子的点数和范围为[n,6n]，即可能出现的点数和为6n-n+1=5n+1种
        double[] result = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            // 减去n保证数组从0开始
            result[i - n] = dp[n][i] / all;
        }
        return result;
    }
}
