/**
 * @author psj
 * @date 2022/6/23 9:06
 * @File: 礼物的最大价值47.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
// 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
// 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

public class 礼物的最大价值47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j]表示从左上角到(i,j)后获得的最大价值礼物
        int[][] dp = new int[m][n];

        // 注意第一行和第一列的值需要累加
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[i - 1][0] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];

    }
}
