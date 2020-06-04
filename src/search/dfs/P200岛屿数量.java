package search.dfs;
/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

 

示例 1:

输入:
11110
11010
11000
00000
输出: 1
 */
public class P200岛屿数量 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i ,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int k = 0; k< 4; k++){
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inGrid(grid, newX, newY) && grid[newX][newY] == '1'){
                dfs(grid, newX, newY);
            }
        }

    }
    public boolean inGrid(char[][] grid, int i, int j){
        int rows = grid.length;
        int columns = grid[0].length;
        return i >= 0 && j >= 0 && i < rows && j < columns;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1','1', '0', '1', '0'},
                {'1','1', '0', '0', '0'},
                {'0','0', '0', '0', '0'}};
        P200岛屿数量 p200岛屿数量 = new P200岛屿数量();
        int i = p200岛屿数量.numIslands(grid);
        System.out.println(i);
    }
}
