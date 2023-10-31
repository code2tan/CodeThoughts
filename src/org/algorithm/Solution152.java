package org.algorithm;

class Solution152 {

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max, tempMin = min;
            max = Math.max(Math.max(nums[i] * tempMax, nums[i] * tempMin), nums[i]);
            min = Math.min(Math.min(nums[i] * tempMax, nums[i] * tempMin), nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4};
        System.out.println(new Solution152().maxProduct(arr));
    }
}