package org.algorithm;

class Solution389 {
    public char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret ^= s.charAt(i) ^ t.charAt(i);
        }
        // 题目提示：t.length == s.length + 1
        ret ^= t.charAt(s.length());
        return (char) ret;
    }
}