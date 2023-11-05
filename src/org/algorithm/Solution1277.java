package org.algorithm;

class Solution1277 {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    result += dp[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(new Solution1277().countSquares(arr));
    }
}