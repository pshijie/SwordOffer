/**
 * @author psj
 * @date 2022/6/3 8:54
 * @File: 机器人的运动范围13.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
// 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
// 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

public class 机器人的运动范围13 {
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }

    public int dfs(int i, int j, int m, int n, int k) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return 0;
        }
        if (beyondK(i, j, k)) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i - 1, j, m, n, k) + dfs(i, j - 1, m, n, k) + dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k);
    }

    public boolean beyondK(int num1, int num2, int k) {
        int sumNum1 = sumOfdigit(num1);
        int sumNum2 = sumOfdigit(num2);

        return (sumNum1 + sumNum2) > k;
    }

    public int sumOfdigit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
