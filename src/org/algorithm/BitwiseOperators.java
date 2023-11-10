package org.algorithm;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5; // 二进制表示：0101
        int b = 3; // 二进制表示：0011

        // 按位与
        int andResult = a & b; // 结果：0001，即十进制的1
        System.out.println("按位与：" + andResult);

        // 按位或
        int orResult = a | b; // 结果：0111，即十进制的7
        System.out.println("按位或：" + orResult);

        // 按位异或
        int xorResult = a ^ b; // 结果：0110，即十进制的6
        System.out.println("按位异或：" + xorResult);

        // 按位取反
        int notResult = ~a; // 结果：1010，即十进制的-6（补码表示）
        System.out.println("按位取反：" + notResult);

        // NAND操作
        int nandResult = ~(a & b); // 先进行"与"运算，然后取反
        System.out.println("NAND：" + Integer.toBinaryString(nandResult)); // 输出：1001

        // NOR操作
        int norResult = ~(a | b); // 先进行"或"运算，然后取反
        System.out.println("NOR：" + Integer.toBinaryString(norResult)); // 输出：1110

        // 左移
        int leftShiftResult = a << 2; // 结果：10100，即十进制的40
        System.out.println("左移：" + leftShiftResult);

        // 有符号右移
        int signedRightShiftResult = a >> 2; // 结果：1，即十进制的1（因为最高位是符号位）
        System.out.println("有符号右移：" + signedRightShiftResult);

        // 无符号右移
        int unsignedRightShiftResult = a >>> 2; // 结果：2，即十进制的2（所有位移均不考虑符号位）
        System.out.println("无符号右移：" + unsignedRightShiftResult);
    }
}