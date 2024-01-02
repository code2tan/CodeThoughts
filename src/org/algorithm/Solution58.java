package org.algorithm;

class Solution58 {
    public int lengthOfLastWord(String s) {
        String trimStr = s.trim();
        int le = trimStr.length() - 1;
        while (le >= 0) {
            if (trimStr.charAt(le) == ' ') {
                break;
            }
            le--;
        }
        return trimStr.length() - le - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution58().lengthOfLastWord("h"));
    }
}