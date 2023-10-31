package org.algorithm;

class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int index = 0;
        while (index < nums.length) {
            sum += nums[index++];
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {

    }
}