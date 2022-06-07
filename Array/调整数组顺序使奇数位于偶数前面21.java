/**
 * @author psj
 * @date 2022/6/7 9:29
 * @File: 调整数组顺序使奇数位于偶数前面21.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分

public class 调整数组顺序使奇数位于偶数前面21 {
    // 方法1:额外数组
    public int[] exchange_array(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                result[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    // 方法2:双指针
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 左指针向右移动,直到遇到偶数
            while (left <= right && nums[left] % 2 == 1) {
                left++;
            }
            // 右指针向左移动,直到遇到奇数
            while (left <= right && nums[right] % 2 == 0) {
                right--;
            }
            if (left > right) {
                break;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }
}
