package array;
/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
 */
public class P240搜索二维矩阵II {
    // 每次都跟最右边的相比较 排除一列 或者 一行
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null){
            return false;
        }
        int row = matrix.length;
        if (row == 0){
            return false;
        }
        int column = matrix[0].length;
        if (column == 0){
            return false;
        }
        int curRow = 0;
        int curColumn = column -1;
        while (curColumn >= 0 && curRow <= row -1){
            if (matrix[curRow][curColumn] > target){
                curColumn--;
            }
            else if (matrix[curRow][curColumn] < target){
                curRow++;
            }
            else  {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        boolean b = new P240搜索二维矩阵II().searchMatrix(m, 5);
        System.out.println(b);
    }
}
