package array;

public class P566重塑矩阵 {
    // 多维 先转 一维 ； 再一维 转 多维
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (row * column != r * c){
            return nums;
        }
        int[][] ans = new int[r][c];
        int[] sub = new int[r*c];
        int flag = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sub[++flag] = nums[i][j];
            }
        }
        flag = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ans[i][j] = sub[++flag];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        P566重塑矩阵 p566重塑矩阵 = new P566重塑矩阵();
        int[][] ints = p566重塑矩阵.matrixReshape(nums, 1, 4);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println(i);
            }
        }
    }
}
