package org.algorithm;

import java.util.Stack;

class Solution2696 {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (sb.length() >= 2) {
                CharSequence charSequence = sb.subSequence(sb.length() - 2, sb.length());
                if (charSequence.equals("AB") || charSequence.equals("CD")) {
                    sb.delete(sb.length() - 2, sb.length());
                }
            }
        }
        return sb.length();
    }

    public int minLength2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && s.charAt(i) == 'B')
                    || (stack.peek() == 'C' && s.charAt(i) == 'D'))) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2696().minLength2("ABFCACDB"));
    }
}