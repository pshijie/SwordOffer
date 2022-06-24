import java.util.Map;

/**
 * @author psj
 * @date 2022/6/24 9:08
 * @File: 丑数49.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/chou-shu-lcof/
// 我们把只包含质因子2、3和5的数称作丑数。求按从小到大的顺序的第n个丑数

public class 丑数49 {
    // 丑数性质:只包含因子 2, 3, 5，因此丑数=某较小丑数×某因子
    // 丑数x_n+1 = min(x_a*2,x_b*3,x_c*5)
    public int nthUglyNumber(int n) {
        // dp[i]表示第i个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            // 第a丑数个数需要通过乘2来得到下个丑数
            // 第b丑数个数需要通过乘3来得到下个丑数
            // 第c丑数个数需要通过乘5来得到下个丑数
            dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
            // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
            if (dp[i] == dp[a] * 2) {
                a++;
            }
            // 第 b个数已经通过乘3得到了一个新的丑数，那下个需要通过乘3得到一个新的丑数的数应该是第(b+1)个数
            if (dp[i] == dp[b] * 3) {
                b++;
            }
            // 第c个数已经通过乘5得到了一个新的丑数，那下个需要通过乘5得到一个新的丑数的数应该是第(c+1)个数
            if (dp[i] == dp[c] * 5) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
