package org.algorithm;

class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int countT = 0, countF = 0;
        int left = 0, right = 0;
        for (; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }
            if (countT > k && countF > k) {
                // 此时正确和错误都不满足
                if (answerKey.charAt(left++) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
            }
        }
        return right - left;
    }


    public static void main(String[] args) {
        // "TTFTTFTT"
        System.out.println(new Solution2024().maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}