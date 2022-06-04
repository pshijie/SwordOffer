/**
 * @author psj
 * @date 2022/6/4 9:45
 * @File: 打印从1到最大的n位数17.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999

public class 打印从1到最大的n位数17 {
    // 未考虑大数
    public int[] printNumbers_small(int n) {
        int num = (int) (Math.pow(10, n) - 1);
        int[] result = new int[num];
        for (int i = 0; i < num; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    // 考虑大数:当n很大时,需要存储的数字会超过数值形能保存的最大范围
    // 所以大数的表示应用字符串String类型,并且使用全排列
    int[] result;
    int count = 0;  // 当前结果数组的下标

    public int[] printNumbers(int n) {
        result = new int[(int) Math.pow(10, n) - 1];
        // digit表示当前要打印整数的位数
        for (int digit = 1; digit <= n; digit++) {
            // first表示每个整数的首位数字
            for (char first = '1'; first <= '9'; first++) {
                char[] num = new char[digit];
                num[0] = first;  // 为了避免数字开头出现0，先把首位first固定
                dfs(1, num, digit);
            }
        }
        return result;
    }

    public void dfs(int index, char[] num, int digit) {
        // index表示当前遍历整数的当前位数
        if (index == digit) {
            result[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        // 开始递归遍历当前整数剩余位数的值(后续的值可以是0)
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }
}