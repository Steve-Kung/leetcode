package list;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class P01 {
    public class Solution {
        public boolean Find(int target, int [][] array) {
            if (array == null){
                return false;
            }
            if (array.length == 0){
                return false;
            }
            if (array[0].length == 0){
                return false;
            }
            int rows = array.length;
            int columns = array[0].length;
            int row = 0;
            int column = columns - 1;
            while (row < rows && column >= 0){
                if (target > array[row][column]){
                    row++;
                } else if(target < array[row][column]){
                    column--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
