package org.algorithm;

class Solution58 {
    public int lengthOfLastWord(String s) {
        String trimStr = s.trim();
        int len = trimStr.length() - 1;
        while (len >= 0) {
            if (trimStr.charAt(len) == ' ') {
                break;
            }
            len--;
        }
        return trimStr.length() - len - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("h"));
    }
}