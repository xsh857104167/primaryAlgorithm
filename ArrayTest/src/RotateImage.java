import org.junit.Test;

import java.util.Arrays;

/**
 * @author Murphy Xu
 * @create 2021-07-19 16:32
 */
public class RotateImage {
    /**
     * 再调整行行号，再转置
     * 0ms,100%；38.7MB,10.38%
     * @param matrix
     */
    public void rotate(int[][] matrix){
        int[] tmp;
        for (int i = 0; i < matrix.length/2; i++) {
            tmp = matrix[i];
            matrix[i] = matrix[matrix.length-i-1];
            matrix[matrix.length-i-1] = tmp;
        }
        transposition(matrix);
    }

    /**
     * 转置
     * @param matrix
     */
    public void transposition(int[][] matrix){
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    /**
     * 观察规律，直接赋值，旋转
     * 0ms,100%;38.6MB,37.76%
     * 关键等式：matrixnew[col][n-row-1] = matrix[row][col]
     * @param matrix
     */
    public void rotate2(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < (n+1)/2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }

    }

    @Test
    public void test(){
        int[][] matrix =
                {{1,2,3},
                {4,5,6},
                {7,8,9}};
        int[][] matrix2 = {{5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}};
        rotate2(matrix2);
//        System.out.println(Arrays.toString(matrix));
        for (int i = 0; i < matrix2.length; i++) {
            System.out.println(Arrays.toString(matrix2[i]));
        }
    }
}
