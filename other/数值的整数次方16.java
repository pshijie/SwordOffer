/**
 * @author psj
 * @date 2022/6/4 9:17
 * @File: 数值的整数次方16.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
// 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题

public class 数值的整数次方16 {
    // 快速幂
    // 先理解二分推导:x^n=x^(n/2)*x^(n/2)=(x^2)^(n/2)
    // 1.当n为偶数时,x^n=(x^2)^(n//2)
    // 1.当n为奇数时,x^n=x*(x^2)^(n//2)
    // 算法流程:
    // 1.当x=0时,返回0(避免后续x=1/x报错)
    // 2.初始化result=1
    // 3.当n<0时,将问题转换为即x=1/x,n=-n
    // 4.
    //  while(n!=0){
    //      当n为奇数时,将当前x乘入res
    //      执行x=x^2
    //      将n除以2
    //  }
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        // 之所以用long存储b是因为假如n=−2147483648,取反后为2147483648
        // 而int类型数字范围在[−2147483648,2147483647],会越界
        long b = n;
        double result = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            // 1.当b为奇数时,需要多乘一个x(因为在上一轮x*=x少乘了一个x)
            // 2.当幂次除到为1后把x赋值给result
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;  // x=x^2
            b >>= 1;  // b=b//2
        }
        return result;
    }
}
