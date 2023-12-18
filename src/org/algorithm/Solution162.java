package org.algorithm;

class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 递减方向
                right = mid;
            } else {
                // 递增方向
                left++;
            }
        }
        return left;
    }
}