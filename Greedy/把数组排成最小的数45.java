import java.util.Arrays;

/**
 * @author psj
 * @date 2022/6/22 8:59
 * @File: 把数组排成最小的数45.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
// 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个

public class 把数组排成最小的数45 {
    // 方法1:使用内置函数
    public String minNumber_comparator(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            temp[i] = String.valueOf(nums[i]);
        Arrays.sort(temp, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : temp)
            res.append(s);
        return res.toString();
    }

    // 方法2:快排
    public String minNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            temp[i] = String.valueOf(nums[i]);
        quickSort(temp, 0, nums.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : temp)
            res.append(s);
        return res.toString();
    }

    public void quickSort(String[] temp, int low, int high) {
        if (low < high) {
            int mid = getMiddle(temp, low, high);
            quickSort(temp, low, mid - 1);
            quickSort(temp, mid + 1, high);
        }
    }

    public int getMiddle(String[] temp, int low, int high) {
        // 以数组的第一个数为基准元素
        String dummy = temp[low];
        while (low < high) {
            // 一般的排序从后向前找比基准元素小的数
            // 这里是自定义排序,满足x+y<y+x,则x排y的前面
            while (low < high && (temp[high] + dummy).compareTo(dummy + temp[high]) >= 0) {
                high--;
            }
            //把比基准小的数移到低端(这里修改为自定义排序的规则)
            temp[low] = temp[high];
            while (low < high && (temp[low] + dummy).compareTo(dummy + temp[low]) <= 0) {
                low++;
            }
            //把比基准大的数移到高端(这里修改为自定义排序的规则)
            temp[high] = temp[low];
        }
        temp[low] = dummy;
        return low;
    }
}