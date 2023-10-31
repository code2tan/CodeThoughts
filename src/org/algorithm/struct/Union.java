package org.algorithm.struct;

public class Union {
    int n = 1005; // n根据题目中节点数量而定，一般比节点数量大一点就好
    int[] father = new int[n];

    // 并查集初始化
    void init() {
        for (int i = 0; i < n; ++i) {
            father[i] = i;
        }
    }

    // 并查集里寻根的过程
    int find(int u) {
        if (u < 0 || u >= father.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        // 路径压缩
        return father[u] = u == father[u] ? u : find(father[u]);
    }

    // 判断 u 和 v是否找到同一个根
    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    // 将v->u 这条边加入并查集
    void join(int u, int v) {
        int uRoot = find(u); // 寻找u的根
        int vRoot = find(v); // 寻找v的根
        if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回
        father[vRoot] = uRoot;
    }
}
