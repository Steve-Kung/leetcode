package dp.array;
/*
给定一个包含非负整数的 m x n 网格，
请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class P64最小路径和 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        int sumRow = 0;
        int sumColumn = 0;
        for (int i = 0; i < rows; i++){
            dp[i][0] = sumRow + grid[i][0];
            sumRow = dp[i][0];
        }
        for (int j = 0; j < columns; j++){
            dp[0][j] = sumColumn + grid[0][j];
            sumColumn = dp[0][j];
        }
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < columns; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
