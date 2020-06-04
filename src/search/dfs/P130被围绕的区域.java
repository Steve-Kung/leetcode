package search.dfs;
/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
 */
// 先找到边界上的'O'
// 再对其进行dfs搜索
// 将连通区域变成'#'
// 最后再将所有的O变换成'X','#' 变换成'O'。
public class P130被围绕的区域 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                // 从边缘O开始搜素
                boolean isEdge = (i == 0 || j == 0 || i == rows - 1 || j == columns - 1);
                if (isEdge && board[i][j] == 'O'){
                    dfs(board, i , j);
                }
            }
        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '#' || grid[i][j] == 'X'){
            // 超出边界
            //  '#' 已经访问过了
            // 'X' 不用访问
            return;
        }
        grid[i][j] = '#';
        // dfs递归
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i , j + 1);
    }

}

/*
public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从边缘o开始搜索
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length  || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j); // 上
        dfs(board, i + 1, j); // 下
        dfs(board, i, j - 1); // 左
        dfs(board, i, j + 1); // 右
    }
 */
