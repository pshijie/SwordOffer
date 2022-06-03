/**
 * @author psj
 * @date 2022/6/3 9:39
 * @File: 剪绳子II14.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
// 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]
// 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
// 答案需要取模 1e9+7（1000000007）

public class 剪绳子II14 {
    // 重点在于循环取余,保证每次运算都在int范围内
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long result = 1L;
        int p = (int) 1e9 + 7;
        // 循环取余,不能直接使用pow函数
        while (n > 4) {
            result = result * 3 % p;
            n -= 3;
        }
        // 执行到该步时n=2、3或者4
        return (int) (result * n % p);
    }
}
