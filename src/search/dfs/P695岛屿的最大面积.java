package search.dfs;
/*
给定一个包含了一些 0 和 1 的非空二维数组 grid 。

一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
你可以假设 grid 的四个边缘都被 0（代表水）包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。

注意是，把四个方向的都叠加起来计算。
 */
public class P695岛屿的最大面积 {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (grid[i][j] == 1){
                    int area = 1;
                    area += dfs(grid, i , j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        int area = 0;
        grid[i][j] = 0;
        for (int k= 0; k< 4; k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inGrid(grid, newX, newY) && grid[newX][newY] == 1){
                area++;
                area += dfs(grid, newX, newY);
            }
        }
        return area;
    }

    public boolean inGrid(int[][] grid, int i , int j){
        int rows = grid.length;
        int columns = grid[0].length;
        return i >=0 && j >= 0 && i < rows && j < columns;
    }

    public static void main(String[] args) {
        int[][] grid= {{1,1,1}, {1, 0, 0}};
        new P695岛屿的最大面积().maxAreaOfIsland(grid);
    }
}

/*
public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    // 每次调用的时候默认num为1，进入后判断如果不是岛屿，则直接返回0，就可以避免预防错误的情况。
    // 每次找到岛屿，则直接把找到的岛屿改成0，这是传说中的沉岛思想，就是遇到岛屿就把他和周围的全部沉默。
    // ps：如果能用沉岛思想，那么自然可以用朋友圈思想。有兴趣的朋友可以去尝试。
    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i + 1, j, grid);
        num += dfs(i - 1, j, grid);
        num += dfs(i, j + 1, grid);
        num += dfs(i, j - 1, grid);
        return num;

    }
 */
