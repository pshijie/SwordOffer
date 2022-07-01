import java.util.ArrayList;
import java.util.List;

/**
 * @author psj
 * @date 2022/7/1 9:16
 * @File: 和为s的连续正数序列57.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
// 输入一个正整数target，输出所有和为target的连续正整数序列（至少含有两个数）
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列

public class 和为s的连续正数序列57 {
    // 滑动窗口
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        // 最小是3(1+2)
        int sum = 3;
        List<int[]> result = new ArrayList<>();
        // 这里移动到target/2的时候就可以停止了，因为子序列最少有两个数
        // 假如left=target/2，right>target/2，明显不符合
        while (left <= target/2) {
            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                result.add(temp);
                // 因为要找后续的子序列，需要先减去左指针指向的数，并将左指针右移
                sum -= left;
                left++;
            } else if (sum > target) {
                // 当sum>target时,在结果中减去左指针指向的数，并将左指针右移
                sum -= left;
                left++;
            } else {
                // 当sum<target时,先将右指针右移，再在结果中加上右指针移动后指向的数
                right++;
                sum += right;
            }

        }
        return result.toArray(new int[0][]);

    }
}
