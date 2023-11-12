package org.algorithm;

class Solution169 {
    public int majorityElement(int[] nums) {
        int ret = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                ret = num;
            }
            // 投票
            if (ret == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Solution169().majorityElement(nums));
    }
}