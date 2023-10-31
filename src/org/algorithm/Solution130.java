package org.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution_DFS {
    public void solve(char[][] board) {
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            dfs(i, 0, board);
            dfs(i, y - 1, board);
        }
        for (int j = 0; j < y; j++) {
            dfs(0, j, board);
            dfs(x - 1, j, board);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    // 不能使用if，防止前面的修改被二次修改
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') return;
        board[x][y] = 'A';
        dfs(x + 1, y, board);
        dfs(x - 1, y, board);
        dfs(x, y + 1, board);
        dfs(x, y - 1, board);
    }
}

class Solution_BFS {
    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        // 从左侧边，和右侧边遍历
        for (int row = 0; row < rowSize; row++) {
            if (board[row][0] == 'O')
                queue.add(new int[]{row, 0});
            if (board[row][colSize - 1] == 'O')
                queue.add(new int[]{row, colSize - 1});
        }
        /*从上边和下边遍历，在对左侧边和右侧边遍历时我们已经遍历了矩阵的四个角
         所以在遍历上边和下边时可以不用遍历四个角
         */
        for (int col = 1; col < colSize - 1; col++) {
            if (board[0][col] == 'O')
                queue.add(new int[]{0, col});
            if (board[rowSize - 1][col] == 'O')
                queue.add(new int[]{rowSize - 1, col});
        }
        // 广度优先遍历，把没有被 'X' 包围的 'O' 修改成特殊值
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            board[current[0]][current[1]] = 'A';
            for (int[] pos : position) {
                int row = current[0] + pos[0], col = current[1] + pos[1];
                if (row >= 0 && row < rowSize && col >= 0 && col < colSize && board[row][col] == 'O') {
                    queue.add(new int[]{row, col});
                }
            }
        }
        // 遍历数组，把 'O' 修改成 'X'，特殊值修改成 'O'
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (board[row][col] == 'A') board[row][col] = 'O';
                else if (board[row][col] == 'O') board[row][col] = 'X';
            }
        }
    }
}