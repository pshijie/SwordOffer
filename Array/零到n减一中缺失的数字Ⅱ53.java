/**
 * @author psj
 * @date 2022/6/26 9:28
 * @File: 零到n减一中缺失的数字Ⅱ53.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
// 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内
// 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字

public class 零到n减一中缺失的数字Ⅱ53 {
    // 方法1:遍历
    public int missingNumber_traverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    // 方法3:二分法
    // 假设数组为0，1，2，3，4，5，7,缺失数为6
    // 将[0,1,2,3,4,5]视为左数组，7视为右数组
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            // 若nums[m]=m，则右子数组的首位元素在闭区间[m+1, j]
            // 因此执行i=m+1
            if (nums[m] == m) i = m + 1;
                // 若nums[m]!=m，则左子数组的末位元素在闭区间[i,m-1]中
                // 因此执行j=m-1
            else j = m - 1;
        }
        return i;
    }
}
