import java.util.HashMap;
import java.util.Map;

/**
 * @author psj
 * @date 2022/6/23 9:19
 * @File: 最长不含重复字符的子字符串48.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
// 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度

public class 最长不含重复字符的子字符串48 {
    // 方法1:滑动窗口
    public int lengthOfLongestSubstring_window(String s) {
        // 统计各字符最后一次出现的索引位置
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        // 记录当前不重复子字符串的长度
        int temp = 0;
        // 左右指针
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, right);
                temp++;
            } else {
                // 比如abeacfh,此时right指向第二个a,则abe为当前最长不重复子字符串
                // 即移动左指针
                left = Math.max(left, map.get(c));
                temp = right - left;
                // 将该字符此时的位置记录下来
                map.put(c, right);
            }
            result = Math.max(temp, result);
            // 移动右指针
            right++;
        }
        return result;
    }

    // 方法2:动态规划
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        // dp[i]表示以字符s[i]结尾的最长不重复子字符串的长度
        int[] dp = new int[len];
        // 统计各字符最后一次出现的索引位置
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int left = -1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)));
            }
            // 当dp[i−1]<i−left,说明字符s[left]在子字符串dp[i−1]区间之外，则dp[i] = dp[i-1] + 1
            // 当dp[i−1]≥i−left,说明字符s[left]在子字符串dp[i−1]区间之中，则dp[i]的左边界由s[left]决定，即dp[i]=dp[i - 1]
            map.put(s.charAt(i), i);
            if (dp[i - 1] < i - left)
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = dp[i - 1];
        }
        return dp[len - 1];
    }
}