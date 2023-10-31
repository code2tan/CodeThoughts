package org.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution374 {
    public int[] topKFrequent(int[] nums, int k) {
        // 大顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, (a, b) -> b[1] - a[1]);
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.putIfAbsent(num, 0);
            map.computeIfPresent(num, (key, oldValue) -> ++oldValue);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(priorityQueue.poll())[0];
        }
        return res;
    }
}