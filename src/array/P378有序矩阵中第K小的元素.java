package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 */
public class P378有序矩阵中第K小的元素 {
    // 排序后返回
    public int kthSmallest1(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }

    // 题目已知为有序的，所以建议使用二分法
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int column = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row - 1][column - 1];
        while (left < right){
            int mid = (left + right) >>> 1;
            // 找到数组中比mid小于等于的个数
            int count  = findLessEqual(matrix, row, column, mid);
            if (count >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int findLessEqual(int[][] matrix, int row, int column, int mid) {
        int count = 0;
        for (int j = 0; j < row; j++) {
            for (int i = column - 1; i >=0; i--) {
                if (matrix[j][i] <= mid){
                    count += (i+1);
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        P378有序矩阵中第K小的元素 p378有序矩阵中第K小的元素 = new P378有序矩阵中第K小的元素();
        int lessEqual = p378有序矩阵中第K小的元素.findLessEqual(m, 5, 5, 5);
        System.out.println(lessEqual);
        int i = p378有序矩阵中第K小的元素.kthSmallest(m, 5);
        System.out.println(i);
    }


//    // 二分法
//    public int kthSmallest(int[][] matrix, int k) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int left = matrix[0][0];
//        int right = matrix[row - 1][col - 1];
//        // 注意：这里的left mid right是数值，不是索引位置。
//        while (left < right) {
//            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
//            int mid = (left + right) / 2;
//            // 找二维矩阵中<=mid的元素总个数
//            int count = findNotBiggerThanMid(matrix, mid, row, col);
//            if (count < k) {
//                // 第k小的数在右半部分，且不包含mid
//                left = mid + 1;
//            } else {
//                // 第k小的数在左半部分，可能包含mid
//                right = mid;
//            }
//        }
//        return right;
//    }
//
//    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
//        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
//        int i = row - 1;
//        int j = 0;
//        int count = 0;
//        while (i >= 0 && j < col) {
//            if (matrix[i][j] <= mid) {
//                // 第j列有i+1个元素<=mid
//                count += i + 1;
//                j++;
//            } else {
//                // 第j列目前的数大于mid，需要继续在当前列往上找
//                i--;
//            }
//        }
//        return count;
//    }
}
