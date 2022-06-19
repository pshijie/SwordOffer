import java.util.Arrays;

/**
 * @author psj
 * @date 2022/6/19 8:33
 * @File: 数组中出现次数超过一半的数字39.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字

public class 数组中出现次数超过一半的数字39 {
    // 方法1:排序
    public int majorityElement_sort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 方法2:摩尔投票
    public int majorityElement(int[] nums) {
        int x = 0;
        int vote = 0;
        for (int num : nums) {
            // 当vote=0时才去修改x的值,后续的数都是和x比较
            // 剩余数组中众数是不变的
            if (vote == 0) {
                x = num;
            }
            // 数组中下一个数和当前x相等则vote+1
            vote += x == num ? 1 : -1;
        }
        return x;
    }
}
