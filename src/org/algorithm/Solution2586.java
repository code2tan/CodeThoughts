package org.algorithm;

class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int result = 0;
        while (left <= right) {
            if (check(words[left])) {
                result++;
            }
            left++;
        }

        return result;
    }

    public boolean check(String s) {
        return (s.startsWith("a") || s.startsWith("e") || s.startsWith("i")
                || s.startsWith("o") || s.startsWith("u"))
                && (s.endsWith("a") || s.endsWith("e") || s.endsWith("i")
                || s.endsWith("o") || s.endsWith("u"));
    }

    public static void main(String[] args) {
        String[] words = {};
        int left = 1, right = 4;
        System.out.println(new Solution2586().vowelStrings(words, left, right));
    }
}