import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/6/30 9:27
 * @File: 数组中数字出现的次数II56.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
// 在一个数组nums中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字

public class 数组中数字出现的次数II56 {
    // 方法1:HashMap
    public int singleNumber_map(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    // 方法2:位运算
    // 对于出现三次的数字，各二进制位出现的次数都是3的倍数
    // 比如[3,5,3,3]
    // 3=0 0 1 1
    // 3=0 0 1 1
    // 3=0 0 1 1
    // 5=0 1 0 1
    //   0 1 3 4   位数总和
    //   0 1 0 1   对3取余(结果就是5)

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++)
        {
            // 统计当前位数上1的总个数
            int oneCount = 0;
            for (int j = 0; j < nums.length; j++)
            {
                // 遍历每个数,将其最右边的数(0/1)取出进行累加
                oneCount += (nums[j] >>> i) & 1;
            }
            // 如果当前位数累加的数余数为1(余数只有0和1的情况，因为只有1个数只出现一次)
            // 将result当前位置为1
            if (oneCount % 3 == 1)
                result |= (1 << i);
        }
        return result;
    }

}
