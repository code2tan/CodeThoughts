package org.algorithm;

class Solution221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    // 取（左边，上边，左上边）最小值 + 1
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    maxSide = Math.max(dp[i + 1][j + 1], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}