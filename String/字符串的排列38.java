import java.util.*;

/**
 * @author psj
 * @date 2022/6/17 8:55
 * @File: 字符串的排列38.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
// 输入一个字符串，打印出该字符串中字符的所有排列

public class 字符串的排列38 {
    List<String> list = new ArrayList<>();
    char[] c;

    public String[] permutation_swap(String s) {
        c = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int rowIndex) {
        // 已经遍历了所有字符
        if (rowIndex == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        // 防止同一层递归出现重复元素
        // 比如在图中第二层出现两个b,则第二个b子树就不需要了
        //                  a
        //                /   \×
        //               b     b
        //              /\
        //              ...
        Set<Character> set = new HashSet<>();
        for (int i = rowIndex; i < c.length; i++) {
            // 当前元素已经被遍历过
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            // 这里把rowIndex理解为同一树层的元素下标
            // 对于字符串abc，第一树层就有a、b和c(对于下标0,1,2)
            // 所以对于第一树层就是a和b交换,然后a和c交换
            swap(i, rowIndex);
            dfs(rowIndex + 1);
            swap(i, rowIndex);
        }
    }

    public void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }

    List<String> result;
    StringBuilder temp;
    boolean[] visited;

    public String[] permutation(String s) {
        this.result = new ArrayList<>();
        this.temp = new StringBuilder();
        this.visited = new boolean[s.length()];

        char[] temp = s.toCharArray();
        // 先排序
        Arrays.sort(temp);
        dfs(temp, 0);
        return result.toArray(new String[s.length()]);
    }

    public void dfs(char[] cs, int depth) {
        if (depth == cs.length) {
            result.add(temp.toString());
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            // 如果当前元素已经被遍历过(可以理解为出现在同一颗子树中)
            if (visited[i]) {
                continue;
            }
            // 执行到该步说明visited[i]==false：
            // 此时visited[i - 1]==false表示cs[i-1]在同一个层中已经使用过(因为已经回溯了)
            if (i > 0 && cs[i - 1] == cs[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            temp.append(cs[i]);

            dfs(cs, depth + 1);

            visited[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

}
