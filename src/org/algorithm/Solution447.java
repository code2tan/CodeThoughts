package org.algorithm;

import java.util.HashMap;
import java.util.Map;

class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] q : points) {
                // 计算欧氏距离
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.compute(dis, (key, value) -> value == null ? 1 : value + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                // 计算能构成回旋镖的所有排列数
                if (m > 1) {
                    ans += m * (m - 1);
                }
            }
        }
        return ans;
    }
}