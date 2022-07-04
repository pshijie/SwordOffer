import java.util.Map;

/**
 * @author psj
 * @date 2022/7/4 9:46
 * @File: 股票的最大利润63.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
// 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少?

public class 股票的最大利润63 {
    // 方法1:双重循环
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int curProfit = prices[j] - prices[i];
                result = result > curProfit ? result : curProfit;
            }
        }
        return result;
    }

    // 方法2:动态规划
    // 前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
    public int maxProfit_dp(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // dp[i]表示第i+1天的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;
        // 前i天的最小买入成本
        int cost = prices[0];
        for (int i = 1; i < prices.length; i++) {
            cost = Math.min(cost, prices[i - 1]);
            dp[i] = Math.max(dp[i - 1], prices[i] - cost);
        }
        return dp[prices.length - 1];
    }
}
