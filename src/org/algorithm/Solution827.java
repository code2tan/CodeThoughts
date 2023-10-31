package org.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution827 {
    private static final int[][] durations = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;
        grid[row][col] = mark;
        for (int[] duration : durations) {
            int curRow = row + duration[0], curCol = col + duration[1];
            if (inArea(curRow, curCol, grid) && grid[curRow][curCol] == 1) {
                ans += 1 + dfs(grid, curRow, curCol, mark);
            }
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE, size = grid.length, mark = 2;
        Map<Integer, Integer> island2Area = new HashMap<>();
        // 标记岛屿
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 1) {
                    int area = 1 + dfs(grid, row, col, mark);
                    island2Area.put(mark++, area);
                }
            }
        }
        // 计算最大岛屿面积
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] != 0) continue;
                Set<Integer> visited = new HashSet<>();
                int curSize = 1;
                for (int[] current : durations) {
                    int curRow = row + current[0], curCol = col + current[1];
                    if (!inArea(curRow, curCol, grid)) continue;
                    int island = grid[curRow][curCol];
                    if (visited.contains(island) || !island2Area.containsKey(island)) continue;
                    visited.add(island);
                    curSize += island2Area.get(island);
                }
                ans = Math.max(ans, curSize);
            }
        }
        // 当 ans == Integer.MIN_VALUE 说明矩阵数组中不存在 0，全都是有效区域，返回数组大小即可
        return ans == Integer.MIN_VALUE ? size * size : ans;
    }

    private boolean inArea(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}