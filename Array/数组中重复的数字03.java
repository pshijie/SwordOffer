import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/5/30 9:33
 * @File: 数组中重复的数字03.java
 * @Software: IntelliJ IDEA
 */

// https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
// 在一个长度为n的数组nums里的所有数字都在0～n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字

public class 数组中重复的数字03 {
    // 方法1:使用额外空间Set
    public int findRepeatNumber_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    // 方法2:原地交换
    //遍历中，第一次遇到数字x时，将其交换至索引x处；而当第二次遇到数字x时，一定有nums[x]=x,此时即可得到一组重复数字
    public int findRepeatNumber(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            // 说明此数字已在对应索引位置，无需交换，因此跳过
            if (nums[i] == i) {
                i++;
                continue;
            }
            // 代表索引nums[i]处和索引i处的元素值都为nums[i]，即找到一组重复值
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            // 交换索引为i和nums[i]的元素值，将此数字交换至对应索引位置
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}
