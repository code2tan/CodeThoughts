package org.algorithm.graph;

/**
 * <a href="https://leetcode.cn/problems/number-of-islands/">200. 岛屿数量</a>
 */
class Solution200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int nextX, int nextY) {
        if (inArea(nextX, nextY, grid) || grid[nextX][nextY] == '0') {
            return;
        }
        grid[nextX][nextY] = '0';
        dfs(grid, nextX + 1, nextY);
        dfs(grid, nextX - 1, nextY);
        dfs(grid, nextX, nextY + 1);
        dfs(grid, nextX, nextY - 1);
    }

    private static boolean inArea(int nextX, int nextY, char[][] grid) {
        return nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length;
    }
}