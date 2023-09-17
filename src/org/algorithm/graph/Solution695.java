package org.algorithm.graph;

class Solution695 {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int x, int y, int[][] grid) {
        if (!inArea(x, y, grid) || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return dfs(x + 1, y, grid)
                + dfs(x - 1, y, grid)
                + dfs(x, y + 1, grid)
                + dfs(x, y - 1, grid) + 1;
    }

    private static boolean inArea(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}