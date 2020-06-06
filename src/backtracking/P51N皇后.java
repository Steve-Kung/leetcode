package backtracking;

import org.junit.Test;

import java.util.*;

/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

回溯算法就是个多叉树的遍历问题，关键就是在前序遍历和后序遍历的位置做一些操作，算法框架如下：
def backtrack(...):
    for 选择 in 选择列表:
        做选择
        backtrack(...)
        撤销选择

写 backtrack 函数时，需要维护走过的「路径」和当前可以做的「选择列表」，
当触发「结束条件」时，将「路径」记入结果集。

 */
public class P51N皇后 {
    List<List<String>> res;

    public List<String> charArrayArrayTOListString(char[][] board){
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return null;
        }
        // 初始化棋盘
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        // 递归结束条件
        if (row == board.length){
            List<String> strings = charArrayArrayTOListString(board);
            res.add(strings);
            return;
        }
        for (int column = 0; column < board[row].length; column++){
            // 剪枝
            if (!isVaild(board, row, column)){
                continue;
            }
            // 做出选择
            board[row][column] = 'Q';
            // 递归
            backtrack(board, row + 1);
            // 取消选择
            board[row][column] = '.';

        }
    }

    private boolean isVaild(char[][] board, int row, int column) {
        // 列不符合
        for (int i = row - 1; i >= 0; i--){
            if (board[i][column] == 'Q'){
                return false;
            }
        }
        // 主对角线不符合
        for (int i = row - 1, j = column - 1; i >= 0 &&  j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        // 副对角线不符合
        for (int i = row - 1, j = column + 1; i >= 0 &&  j < board[i].length; i--, j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }


    /**
     * 思考路径：
     * 1. 定位这是backtrack problem
     * 2. 思考决策树的构建过程
     * 3. 思考回溯的模板
     */
    // 决策树的每一层表示棋盘上的每一行；每个节点可以做出的选择是，在该行的任意一列放置一个皇后。
    static class Solution1 {
        List<List<String>> res;

        private static List<String> charToString(char[][] array) {
            List<String> result = new LinkedList<>();
            for (char[] chars : array) {
                result.add(String.valueOf(chars));
            }
            return result;
        }

        // 输入棋盘边长 n，返回所有合法的放置
        public List<List<String>> solveNQueens(int n) {
            if (n <= 0) return null;
            res = new LinkedList<>();
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
            char[][] board = new char[n][n];
            for (char[] chars : board) {
                Arrays.fill(chars, '.');
            }
            backtrack(board, 0);
            return res;
        }

        /**
         * 路径：board中小于row的那些行都已经成功放置了皇后
         * 可选择列表: 第row行的所有列都是放置Q的选择
         * 结束条件: row超过board的最后一行
         *
         * @param board
         * @param row
         */
        private void backtrack(char[][] board, int row) {
            // 触发结束条件
            if (row == board.length) {
                res.add(charToString(board));
                return;
            }
            int n = board[row].length;
            for (int col = 0; col < n; col++) {
                // 排除不合法选择
                if (!isValid(board, row, col)) {
                    continue;
                }
                // 做选择
                board[row][col] = 'Q';
                // 进入下一行决策
                backtrack(board, row + 1);
                // 撤销选择
                board[row][col] = '.';
            }
        }

        private boolean isValid(char[][] board, int row, int col) {
            int rows = board.length;
            // check is valid in col
            for (char[] chars : board) {
                if (chars[col] == 'Q') {
                    return false;
                }
            }
            // check is valide upright
            for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            // check is valide upleft
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

    }

}
