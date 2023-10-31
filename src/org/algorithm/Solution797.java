package org.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">797. 所有可能的路径</a>
 */
class Solution797 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);
        dfs(graph, 0);
        return result;
    }

    private void dfs(int[][] graph, int nextNodeIndex) {
        if (nextNodeIndex == graph.length - 1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[nextNodeIndex].length; i++) {
            int nodeIndex = graph[nextNodeIndex][i];
            path.add(nodeIndex);
            dfs(graph, nodeIndex);
            path.remove(path.size() - 1);
        }
    }
}