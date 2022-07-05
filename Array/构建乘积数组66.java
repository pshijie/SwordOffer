/**
 * @author psj
 * @date 2022/7/5 9:43
 * @File: 构建乘积数组66.java
 * @Software: IntelliJ IDEA
 */
// 给定一个数组A[0,1,…,n-1]，请构建一个数组B[0,1,…,n-1]，其中B[i]的值是数组A中除了下标i以外的元素的积,
// 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法

public class 构建乘积数组66 {
    // 将B[i]的计算拆分为A[0]*...A[i-1]和A[i+1]*...A[n-1]
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int n = a.length;
        // 表示当前位置i左侧的乘积和右侧的乘积
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // left[i]=A[0]*...A[i-1]
            // right[i]=A[i+1]*...A[n-1]
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
