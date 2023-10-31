package org.algorithm;

class Solution463 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += dfs(i, j, grid);
                }
            }
        }
        return result;
    }

    private int dfs(int row, int col, int[][] grid) {
        // 当坐标不在范围内或者是水即是边
        if (!inArea(row, col, grid) || grid[row][col] == 0) {
            return 1;
        }
        // 已经访问的格子
        if (grid[row][col] == 2) {
            return 0;
        }
        grid[row][col] = 2;
        int result = 0;
        for (int[] direction : directions) {
            int x = direction[0] + row;
            int y = direction[1] + col;
            result += dfs(x, y, grid);
        }
        return result;
    }

    private boolean inArea(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] ar = {{1, 0}};
        System.out.println(new Solution463().islandPerimeter(ar));
    }
}