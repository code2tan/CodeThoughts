package org.algorithm;

class Solution684 {
    int[] father;

    public int[] findRedundantConnection(int[][] edges) {
        init();
        for (int[] edge : edges) {
            int uRoot = find(edge[0]);
            int vRoot = find(edge[1]);
            if (uRoot == vRoot) {
                return edge;
            } else {
                father[uRoot] = vRoot;
            }
        }
        return new int[]{};
    }

    void init() {
        int n = 1001;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    int find(int n) {
        return father[n] = father[n] == n ? n : find(father[n]);
    }

}