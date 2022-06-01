/**
 * @author psj
 * @date 2022/6/1 9:49
 * @File: 旋转数组的最小数字11.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
// 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转
// 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素

public class 旋转数组的最小数字11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当nums[m] < nums[j]时：m一定在右排序数组中，即旋转点x一定在[i, m]闭区间内
            if (numbers[mid] < numbers[right]) {
                right = mid;
                //当nums[m] > nums[j]时：m一定在左排序数组中，即旋转点x一定在[m + 1, j]闭区间内
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
                // 当 nums[m] = nums[j]时：无法判断m在哪个排序数组中，即无法判断旋转点x在[i,m]还是[m+1,j]区间中
                // 解决方案：执行j = j - 1缩小判断范围
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
