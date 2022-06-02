import java.util.Stack;

/**
 * @author psj
 * @date 2022/6/2 8:13
 * @File: 矩阵中的路径12.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/
// 给定一个mxn二维字符网格board和一个字符串单词word。如果word存在于网格中，返回true；否则返回false
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用

public class 矩阵中的路径12 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index))
            return false;
        if (index == word.length() - 1) {
            return true;
        }
        board[i][j] = '.';
        boolean res =
                dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        board[i][j] = word.charAt(index);
        return res;

    }
}
