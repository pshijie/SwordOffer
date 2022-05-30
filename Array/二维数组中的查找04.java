/**
 * @author psj
 * @date 2022/5/30 9:54
 * @File: 二维数组中的查找04.java
 * @Software: IntelliJ IDEA
 */
// https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
// 在一个n*m的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数

public class 二维数组中的查找04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;

            } else {
                return true;
            }
        }
        return false;
    }
}
