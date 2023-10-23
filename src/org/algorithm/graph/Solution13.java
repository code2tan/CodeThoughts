package org.algorithm.graph;

class Solution13 {
    public int romanToInt(String s) {
        int result = 0;
        int prentV = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int currentV = getValue(s.charAt(i));
            if (currentV > prentV) {
                result -= prentV;
            } else {
                result += prentV;
            }
            prentV = currentV;
        }
        // 处理数组最后一个数
        result += prentV;
        return result;
    }

    private int getValue(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("IV"));
    }
}