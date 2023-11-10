package org.algorithm;

class Solution326 {
    public boolean isPowerOfThree1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        return n > 0 && Math.pow(3, 19) % 3 == 0;
    }
}