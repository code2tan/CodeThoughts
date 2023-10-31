package org.algorithm;

import java.util.HashSet;
import java.util.Set;

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> cache = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                cache.remove(nums[i - k - 1]);
            }
            if (!cache.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        System.out.println(new Solution219().containsNearbyDuplicate(nums, 2));
    }

}