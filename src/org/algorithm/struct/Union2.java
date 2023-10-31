package org.algorithm.struct;

import java.util.Arrays;

public class Union2 {
    int n = 1005; // n根据题目中节点数量而定，一般比节点数量大一点就好
    int[] father = new int[n]; // C++里的一种数组结构
    int[] rank = new int[n]; // 初始每棵树的高度都为1

    // 并查集初始化
    void init() {
        for (int i = 0; i < n; ++i) {
            father[i] = i;
            Arrays.fill(rank, 1);
        }
    }

    // 并查集里寻根的过程
    int find(int u) {
        // 注意这里不做路径压缩
        return u == father[u] ? u : find(father[u]);
    }

    // 判断 u 和 v是否找到同一个根
    boolean isSame(int u, int v) {
        return find(u) == find(v);
    }

    // 将v->u 这条边加入并查集
    void join(int u, int v) {
        int uRoot = find(u); // 寻找u的根
        int vRoot = find(v); // 寻找v的根

        if (rank[uRoot] <= rank[vRoot]) {
            father[uRoot] = vRoot; // rank小的树合入到rank大的树
        } else {
            father[vRoot] = uRoot;
        }
        // 如果两棵树高度相同，则v的高度+1因为，方面 if (rank[u] <= rank[v]) father[u] = v; 注意是 <=
        if (rank[uRoot] == rank[vRoot] && uRoot != vRoot) {
            rank[vRoot]++;
        }
    }
}
