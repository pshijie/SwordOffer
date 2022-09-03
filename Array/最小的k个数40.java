import java.util.Arrays;

/**
 * @author psj
 * @date 2022/6/19 9:18
 * @File: 最小的k个数40.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
// 输入整数数组arr,找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4

public class 最小的k个数40 {
    // 方法1:API排序
    public int[] getLeastNumbers_sort(int[] arr, int k) {
        int[] result = new int[k];
        if (arr.length < k) {
            return result;
        }
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    // 方法2:快速排序
    // 具体步骤:
    // 初始化哨兵索引位置(即移动的i和j)，以arr[l]为基准数
    // 循环交换,两个哨兵相遇时跳出:
    //     从右向左查找首个小于基准数的元素(移动j)
    //     从左向右查找首个大于基准数的元素(移动i)
    //     交换这两个哨兵所在元素的值
    //  交换基准数arr[l]和arr[i]
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        int[] result = Arrays.copyOf(arr, k);
        return result;
    }

    public void quickSort(int[] arr, int l, int r) {
        // 即当前数组的长度为1
        if (l >= r) {
            return;
        }
        // arr[l]为基准数,i和j为哨兵
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 此时两个哨兵相遇,交换基准数arr[l]和arr[i]
        swap(arr, i, l);
        // 递归继续划分左右子数组
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 方法3:快排优化
    // 由于快排每一次确定一个数的最终位置，所以每次确定一个数后和k比较
    // 如果确定数的位置>k,则最小的k个数在左子数组中
    // 如果确定数的位置<k,则最小的k个数在右子数组中
    // 如果确定数的位置=k,则最小的k个数就是左子数组中
    public int[] getLeastNumbers_better(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        return quickSort(arr, k, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr, int k, int l, int r) {
        // arr[l]为基准数,i和j为哨兵
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) {
                j--;
            }
            while (i < j && arr[i] <= arr[l]) {
                i++;
            }
            swap(arr, i, j);
        }
        // 此时两个哨兵相遇,交换基准数arr[l]和arr[i]
        swap(arr, i, l);

        // 如果确定数的位置>k,则最小的k个数在左子数组中
        if (i > k) {
            return quickSort(arr, k, l, i - 1);
        }
        // 如果确定数的位置<k,则最小的k个数在右子数组中
        if (i < k) {
            return quickSort(arr, k, i + 1, r);
        }
        // 如果确定数的位置=k,则最小的k个数就是左子数组中
        return Arrays.copyOf(arr, k);
    }
}
