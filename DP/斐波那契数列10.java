import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/6/1 9:35
 * @File: 斐波那契数列10.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
// 写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项（即F(N)）

public class 斐波那契数列10 {
    // 方法1:递归(超时)
    public int fib_recursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fib_recursion(n - 1) + fib_recursion(n - 2);
    }

    // 方法2:备忘录
    Map<Integer, Integer> map = new HashMap<>();

    public int fib_map(int n) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = (fib_map(n - 1) + fib_map(n - 2)) % 1000000007;
        map.put(n, result);
        return result;
    }

    // 方法3:动态递归
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1e9 + 7;
        }
        return dp[n];
    }
}