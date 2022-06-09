/**
 * @author psj
 * @date 2022/6/9 9:26
 * @File: 顺时针打印矩阵29.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字

public class 顺时针打印矩阵29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int index = 0;
        int top = 0, right = n - 1, bottom = m - 1, left = 0;

        while (true) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result[index++] = matrix[bottom][i];
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result[index++] = matrix[i][left];
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }
}
