package backtracking;
/*
编写一个程序，通过已填充的空格来解决数独问题。
一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。

 // 做选择
 // 继续穷举下一个
 // 撤销选择

 // 为了减少复杂度，我们可以让 backtrack 函数返回值为 boolean，
 如果找到一个可行解就返回 true，这样就可以阻止后续的递归。
 只找一个可行解，也是题目的本意。

 回溯算法 全排列 数独 N皇后

 */
public class P37解数独 {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }
    public boolean backTrack(char[][] board, int i, int j){
        int rows = 9;
        int columns = 9;
        if (j == columns){
            return backTrack(board, i+1, 0);
        }
        if (i == rows){
            return true;
        }
        if (board[i][j] != '.'){
            return backTrack(board, i, j+1);
        }
        for (char ch = '1'; ch <= '9'; ch++){
            // 如果遇到不合法的数字，就跳过
            // 看看数字有没有冲突
            if (!isVaild(board, i, j, ch)){
                continue;
            }

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backTrack(board, i, j+1)){
                return true;
            }
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    private boolean isVaild(char[][] board, int i, int j, char ch) {
        for (int k = 0; k< 9; k++){
            if (board[i][k] == ch) {
                return false;
            }
            if (board[k][j] == ch){
                return false;
            }
            if (board[(i/3) * 3 + k / 3][(j/3)*3 + k % 3] == ch){
                return false;
            }
        }
        return true;
    }

}

/*
public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }
        // 结束条件
        if (i == m) {
            // 找到一个可行解，触发 base case
            return true;
        }

        if (board[i][j] != '.') {
            // 如果有预设数字，不用我们穷举
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳过
            if (!isValid(board, i, j, ch))
                continue;

            // 做选择
            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            // 递归，继续穷举下一个
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            // 撤销旋转
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    // 判断 board[i][j] 是否可以填入 n

//    对于行列为(r, c)的数而言，
//    (r/3, c/3)是它对应的 3 × 3 方框所在的位置，
//    例如第4行第5个数(4, 5)所在的 3 × 3 方框是(1, 1)，
//    也就是第1行第1列的方框，即中间那个（下标全都从0开始）。
//    这两个数再×3，得到的是该方框最左上角的数的坐标(r/3)*3, (c/3)*3。
//    最后一步是遍历这个方框内的9个格子，因为前面我们已经得到这个方框左上角元素的下标了，
//    只需要在它的基础上分别在行和列上加上增量0, 1, 2就可以了。
//    但是因为前面检查行和列的时候我们只用了一个变量i在循环，
//    这里如果要分别遍历行和列的话，需要单独写一个两层循环出来。
//    用i/3和i%3可以用一个变量控制行和列的增量，
//    当i取值从0到8变化时，(i/3, i%3)分别会是(0, 0), (0, 1), ..., (2, 1), (2, 2)，
//    也可以理解成是将一个1×9的一维数组变形成了3×3的二维数组，实现对小方框内数字的遍历。
//    建议代入一些r、c的值，然后把i从0到8对应写出来，会比较直观一些。

boolean isValid(char[][] board, int r, int c, char n) {
    for (int i = 0; i < 9; i++) {
        // 判断行是否存在重复
        if (board[r][i] == n) return false;
        // 判断列是否存在重复
        if (board[i][c] == n) return false;
        // 判断 3 x 3 方框是否存在重复
        if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
            return false;
    }
    return true;
}
 */
