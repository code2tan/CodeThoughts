package org.algorithm;

import org.algorithm.struct.TreeNode;

class Solution530 {
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode curr) {
        if (curr == null) {
            return;
        }
        // 左
        traversal(curr.left);
        // 中
        if (prev != null) {
            result = Math.min(result, Math.abs(curr.val - prev.val));
        }
        prev = curr;
        // 右
        traversal(curr.right);
    }
}