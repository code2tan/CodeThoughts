package org.algorithm;

import org.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution501 {

    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        travel(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    // 最多重复的次数
    int maxCount = 0;
    // 统计重复的次数
    int count = 0;
    TreeNode pre = null;
    private void travel(TreeNode curr) {
        if (curr == null) {
            return;
        }
        travel(curr.left);
        if (pre == null || pre.val != curr.val) {
            count = 1;
        } else {
            count++;
        }
        if (count == maxCount) {
            result.add(curr.val);
        }
        // 处理maxValue被更新的情况
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(curr.val);
        }
        pre = curr;
        travel(curr.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        int[] mode = new Solution501().findMode(root);
        for (int i : mode) {
            System.out.println(i);
        }
    }
}