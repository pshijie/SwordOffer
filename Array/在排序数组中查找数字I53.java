/**
 * @author psj
 * @date 2022/6/26 8:58
 * @File: 在排序数组中查找数字I53.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
// 统计一个数字在排序数组中出现的次数

public class 在排序数组中查找数字I53 {
    // 方法1:计数法
    public int search_count(int[] nums, int target) {
        int result = 0;
        for (int num : nums) {
            if (num == target) {
                result++;
            }
        }
        return result;
    }

    // 方法2:二分法1
    public int search_1(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        // 左右指针分别指向target序列的左边一位和右边一位
        int i = 0;
        int j = nums.length - 1;
        // 找右边一位
        while (i <= j) {
            int mid = i + (j - i) / 2;
            // 包含了等于的情况，目的是将i移到target序列的右边一位
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // 若数组中无 target则返回
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        // 跳出while循环的条件为i>j，通过上述判断说明nums[j]=target,
        // 所以i位置正好是target序列的右边一位
        int right = i;

        // 重置指针
        i = 0;
        j = nums.length - 1;
        // 找左边一位
        while (i <= j) {
            int mid = i + (j - i) / 2;
            // 包含了等于的情况，目的是将j移到target序列的左边一位
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        // 跳出while循环的条件为i>j,所以j位置正好是target序列的左边一位
        int left = j;
        return right - left - 1;
    }

    // 方法3:二分法2
    public int search_2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[low] == nums[high]) {
                    return high - low + 1;
                }
                if (nums[low] < target) {
                    low++;
                }
                if (nums[high] > target) {
                    high--;
                }
            }

        }
        return 0;
    }
}
