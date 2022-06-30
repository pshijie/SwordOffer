import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/6/30 9:58
 * @File: 和为s的两个数字57.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
// 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可

public class 和为s的两个数字57 {
    // 方法1:双指针
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] + nums[right]) < target) {
                left++;
            } else if ((nums[left] + nums[right]) > target) {
                right--;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return null;
    }

    // 方法2:Hash
    public int[] twoSum_set(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int e = target - num;
            if (set.contains(e)) {
                return new int[]{num, e};
            }
        }
        return null;
    }
}