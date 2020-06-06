package backtracking;
/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。 
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

// 优先查看 class ans1 的解答 更加符合模板
 */
public class P79单词搜索 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0){
            return false;
        }
        int rows = board.length;
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (backtrack(board, i, j ,word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int i, int j, String word, int index) {
        if (index == word.length() - 1){
            return board[i][j] == word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)){
            visited[i][j] = true;
            for (int k = 0; k < 4; k++){
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if (inGrid(board, newX, newY) && !visited[newX][newY]){
                    if (backtrack(board, newX, newY, word, index + 1)){
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
    public boolean inGrid(char[][] board, int i, int j){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }


    class ans2{
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0){
                return false;
            }
            int rows = board.length;
            int columns = board[0].length;
            boolean[][] visited = new boolean[rows][columns];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    if (board[i][j] == word.charAt(0) && backtrack(board, i , j, visited, word, 0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
            // 递归终止条件
            if(index == word.length()){
                return true;
            }
            if (!inGrid(board, i , j) || board[i][j] != word.charAt(index) || visited[i][j]){
                return false;
            }
            visited[i][j] = true;
            if (backtrack(board, i - 1, j, visited, word, index + 1) ||
                    backtrack(board, i + 1, j, visited, word, index + 1) ||
                    backtrack(board, i, j - 1, visited, word, index + 1) ||
                    backtrack(board, i, j + 1, visited, word, index + 1)
                    ){
                return true;
            }
            visited[i][j] = false;

            return false;
        }
        public boolean inGrid(char[][] board, int i, int j){
            return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
        }
    }

    class ans1{
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0){
                return false;
            }
            int rows = board.length;
            int columns = board[0].length;
            boolean[][] visited = new boolean[rows][columns];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < columns; j++){
                    // 对第一个字符进行选择
                    if (board[i][j] == word.charAt(0)){
                        visited[i][j] = true;
                        if (backtrack(board, i, j, visited, word, 0)){
                            return true;
                        }
                        visited[i][j] = false;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
            // 递归终止条件
            if(index == word.length() - 1){
                return board[i][j] == word.charAt(index);
            }

            for (int k = 0; k < 4; k++){
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                // 剪枝
                if (!inGrid(board, newX, newY) || visited[newX][newY] || board[newX][newY] != word.charAt(index + 1)){
                    continue;
                }
                // 选择
                visited[newX][newY] = true;
                // 递归
                if (backtrack(board, newX, newY, visited, word, index +1)){
                    return true;
                }
                // 取消选择
                visited[newX][newY] = false;

            }
            return false;

        }
        public boolean inGrid(char[][] board, int i, int j){
            return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
        }
    }
}
