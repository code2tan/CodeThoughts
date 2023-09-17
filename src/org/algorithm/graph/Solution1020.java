package org.algorithm.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution1020_DFS {
    public int numEnclaves(int[][] grid) {
        int x = grid.length - 1;
        int y = grid[0].length - 1;
        // 清理表格四条边
        for (int i = 0; i < x; i++) {
            dfs(i, 0, grid);
            dfs(i, y, grid);
        }
        for (int j = 0; j < y; j++) {
            dfs(0, j, grid);
            dfs(x, j, grid);
        }
        // 统计面积
        int size = 0;
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (grid[i][j] == 1) {
                    size++;
                }
            }
        }
        return size;
    }

    private void dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) return;
        grid[x][y] = 0;
        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }
}

class Solution1020_BFS {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            if (grid[i][0] == 1) {
                queue.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 1; j < n - 1; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            if (grid[0][j] == 1) {
                queue.offer(new int[]{0, j});
            }
            if (grid[m - 1][j] == 1) {
                queue.offer(new int[]{m - 1, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currRow = cell[0];
            int currCol = cell[1];
            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}