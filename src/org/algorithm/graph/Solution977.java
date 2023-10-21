package org.algorithm.graph;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/submissions/476163042/">977. 有序数组的平方</a>
 */
class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int left = 0, right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 根据提议数组一定满足两边大中间小
            result[i] = nums[left] > nums[right] ? nums[left++] : nums[right--];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new Solution977().sortedSquares(arr)));
    }
}