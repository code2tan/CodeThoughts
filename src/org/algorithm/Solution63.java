package org.algorithm;

/**
 * <a href="https://leetcode.cn/problems/unique-paths-ii/">63. 不同路径 II</a>
 */
class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows && obstacleGrid[i][0] != 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < cols && obstacleGrid[0][j] != 1; j++) {
            dp[0][j] = 1;
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    continue;
                }
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    // 空间优化版本
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];

        for (int j = 0; j < cols && obstacleGrid[0][j] == 0; j++) {
            dp[j] = 1;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) {
                    dp[col] = 0;
                } else if (col != 0) {
                    dp[col] += dp[col - 1];
                }
            }
        }
        return dp[cols - 1];
    }
}