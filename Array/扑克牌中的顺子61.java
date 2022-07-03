import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author psj
 * @date 2022/7/3 9:57
 * @File: 扑克牌中的顺子61.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
// 从若干副扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的(大、小王为0,可以看成任意数字)

public class 扑克牌中的顺子61 {
    // 方法1:set
    // 1.除了大小王可以重复,其他牌出现重复的牌就不是顺子
    // 2.最大牌-最小牌<5即可构成顺子*
    public boolean isStraight_set(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            // 除了大小王，还出现重复的牌
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return max - min < 5;
    }

    // 方法2:排序
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int numOfZero = 0;
        // 统计0的个数
        while (nums[numOfZero] == 0) {
            numOfZero++;
        }
        for (int i = numOfZero; i < nums.length - 1; i++) {
            // 非0部分，如果出现相邻元素重复就为false
            if (nums[i + 1] == nums[i]) {
                return false;
            }
            // 使用0补全相邻元素间的差值
            numOfZero -= nums[i + 1] - nums[i] - 1;
            // 如果不够补就为false
            if (numOfZero < 0) {
                return false;
            }
        }
        return true;
    }
}
