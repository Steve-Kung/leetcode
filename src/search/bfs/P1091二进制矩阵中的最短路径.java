package search.bfs;
/*
在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。

一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：

相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
C_1 位于 (0, 0)（即，值为 grid[0][0]）
C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
返回这条 从左上角到右下角 的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。

 

示例 1：

输入：[[0,1],[1,0]]

输出：2
 */

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
void BFS()
{
    定义队列;
    定义备忘录，用于记录已经访问的位置；

    判断边界条件，是否能直接返回结果的。

    将起始位置加入到队列中，同时更新备忘录。

    while (队列不为空) {
        获取当前队列中的元素个数。
        for (元素个数) {
            取出一个位置节点。
            判断是否到达终点位置。
            获取它对应的下一个所有的节点。
            条件判断，过滤掉不符合条件的位置。
            新位置重新加入队列。
        }
    }

}
 */
public class P1091二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (rows == 0 || columns == 0 || grid[0][0] != 0 || grid[rows-1][columns-1] != 0){
            return -1;
        }
        int[][] directions = {{-1, -1},{-1, 0},{-1, 1}, {0, -1},{0, 1}, {1, -1},{1, 0},{1, 1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        grid[0][0] = 1;
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++){
                Integer poll = queue.poll();
                int x = poll / columns;
                int y = poll % columns;
                for (int j = 0; j < 8; j++){
                    int newX = x + directions[j][0];
                    int newY = y + directions[j][1];
                    if (inGrid(grid, newX, newY) && grid[newX][newY] == 0){
                        grid[newX][newY] = level + 1;
                        queue.offer(newX * columns + newY);
                    }
                }
            }

        }
        return grid[rows - 1][columns - 1] == 0 ? -1 : grid[rows - 1][columns - 1];
    }

    public boolean inGrid(int[][] grid, int x, int y){
        int rows = grid.length;
        int columns = grid[0].length;
        return x >=0 && x < rows && y >= 0 && y < columns;
    }


    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        P1091二进制矩阵中的最短路径 p1091二进制矩阵中的最短路径 = new P1091二进制矩阵中的最短路径();
        int i = p1091二进制矩阵中的最短路径.shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }
}

/*
private static int[][] directions = {{0,1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    private int row, col;
    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        if(grid[0][0] == 1 || grid[row - 1][col - 1] == 1) return -1;
        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1; // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        pos.add(new int[]{0,0});
        while(!pos.isEmpty() && grid[row - 1][col - 1] == 0){ // 求最短路径 使用BFS
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]]; // 当前点的路径长度
            for(int i = 0; i < 8; i++){
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if(inGrid(newX, newY) && grid[newX][newY] == 0){
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1; // 下一个点的路径长度要+1
                }
            }
        }
        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1]; // 如果最后终点的值还是0，说明没有到达
    }

    private boolean inGrid(int x, int y){
        return x >= 0 && x < row && y >= 0 && y < col;
    }


    // 标准的BFS格式
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        if (row == 0 || column == 0 || grid[0][0] != 0 || grid[row - 1][column - 1] != 0){
            return -1;
        }
        if (row == 1 && column == 1 && grid[0][0] == 0){
            return 1;
        }
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        queue.offer(new Pair<>( 0 * column + 0 , 1));
        visited.put(0 * column + 0, true);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++){
                Pair<Integer, Integer> poll = queue.poll();
                int key = poll.getKey();
                int x = key / column;
                int y = key % column;
                for (int j = 0; j < 8 ; j++){
                    int newX = x + direction[j][0];
                    int newY = y + direction[j][1];

                    if (newX == row - 1 && newY == column - 1){
                        return level + 1;
                    }

                    if (inGrid(newX, newY, grid) && !visited.containsKey(newX * column + newY) && grid[newX][newY] == 0){
                        queue.offer(new Pair<>(newX * column + newY, level + 1));
                        visited.put(newX * column + newY, true);
                    }
                }

            }
        }
        return -1;
    }
    public boolean inGrid(int x, int y, int[][] grid){
        int row = grid.length;
        int column = grid[0].length;
        return x >= 0 && x < row && y >= 0 && y < column;
    }
 */
