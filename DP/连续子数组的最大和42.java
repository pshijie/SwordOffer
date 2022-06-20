/**
 * @author psj
 * @date 2022/6/20 9:32
 * @File: 连续子数组的最大和42.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值
// 要求时间复杂度为O(n)

public class 连续子数组的最大和42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的连续子数组的最大值
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < n; i++) {
            // 比较以nums[i]作为连续子数组的结尾和不已其作为结尾
            // 如果不以nums[i]作为结尾，则说明需要从位置i开始开辟新的子数组
            // 即(nums[i-m],nums[i-m-1],...nums[i])是以nums[i]结尾
            // 而单独的(nums[i])也是以nums[i]结尾
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
