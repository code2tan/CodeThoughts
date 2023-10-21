package org.algorithm.graph;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/description/">209. 长度最小的子数组</a>
 */
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sumVal = 0;
        int len = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sumVal += nums[right];
            while (sumVal >= target) {
                sumVal -= nums[left++];
                len = Math.min(len, right - left + 1);
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