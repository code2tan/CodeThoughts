package org.algorithm;

import java.util.Arrays;

class Solution1971 {
    int[] father;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length <= destination) {
            return false;
        }
        father = new int[n];
        init();
        for (int[] edge : edges) {
            join(edge[0], edge[1]);
        }
        return isSame(source, destination);
    }

    void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    int find(int n) {
        return father[n] = father[n] == n ? n : find(father[n]);
    }

    // 判断 u 和 v是否找到同一个根
    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    // 将v->u 这条边加入并查集
    void join(int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (u == v) return;
        father[vRoot] = uRoot;
    }
}