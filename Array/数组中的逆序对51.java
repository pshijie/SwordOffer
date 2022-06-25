/**
 * @author psj
 * @date 2022/6/25 9:06
 * @File: 数组中的逆序对51.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数

public class 数组中的逆序对51 {
    // 归并排序，其实就是在归并排序阶段统计逆序对的数目
    // 首先要明确在mergeSort函数中左子数组nums[left...mid]和右子数组nums[mid+1...right]都是排好序的数组
    // 假设左子数组为[2,3,7,9],右子数组为[4,5,6]
    // 此时左指针指向7,右指针指向4,7>4。此时因为左子数组已经排好序，所以7以及7之后的数肯定比4大
    int count;

    public int reversePairs(int[] nums) {
        count = 0;
        merge(nums, 0, nums.length - 1);
        return count;
    }

    // 将nums[left...right]进行排序
    // 同时统计nums[left...right]中所有的逆序对
    public void merge(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            merge(nums, left, mid);
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }

    }

    // 将nums[left...mid]和nums[mid...right]进行排序
    public void mergeSort(int[] nums, int left, int mid, int right) {
        // 保存将两个子数组合并并排好序的数组,最后重新赋值给原数组对应部分
        int[] temp = new int[right - left + 1];
        // 在temp上移动的指针
        int index = 0;
        // m1在左子数组遍历,m2在右子数组遍历
        int m1 = left, m2 = mid + 1;
        while (m1 <= mid && m2 <= right) {
            if (nums[m1] <= nums[m2]) {
                temp[index++] = nums[m1++];
            } else {
                // 执行到该步说明nums[m1]以及后续数要比nums[m2]大
                // 统计左子数组还剩余几位数没有遍历
                count += (mid - m1 + 1);
                temp[index++] = nums[m2++];
            }
        }
        // 执行到该步时左右子数组还有一个没有遍历完
        // 左子数组还有剩余
        while (m1 <= mid) {
            temp[index++] = nums[m1++];
        }
        // 右子数组还有剩余
        while (m2 <= right) {
            temp[index++] = nums[m2++];
        }
        // 将temp数组覆盖到原数组相应位置
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}
