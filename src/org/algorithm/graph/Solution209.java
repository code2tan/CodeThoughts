package org.algorithm.graph;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">209. 长度最小的子数组</a>
 */
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sumVal = 0;
        int len = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sumVal += nums[j];
            while (sumVal >= target) {
                sumVal -= nums[i++];
                len = Math.min(len, j - i + 1);
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        int target = 11;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution209().minSubArrayLen(target, nums));
    }
}