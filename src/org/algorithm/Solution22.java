package org.algorithm;

import java.util.ArrayList;
import java.util.List;

class Solution22 {
    List<String> result = new ArrayList<>();
    private int MAX_NUM;

    public List<String> generateParenthesis(int n) {
        this.MAX_NUM = n;
        backtrack(new StringBuilder(), 0, 0);
        return result;
    }

    /**
     * @param cur   所有组合
     * @param left  左括号下标
     * @param right 右括号下标
     */
    public void backtrack(StringBuilder cur, int left, int right) {
        if (cur.length() == MAX_NUM * 2) {
            result.add(cur.toString());
            return;
        }
        if (left < MAX_NUM) {
            cur.append('(');
            backtrack(cur, left + 1, right);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            backtrack(cur, left, right + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}