package com.easy.leetcode;

/**
 * @ClassName reverse
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 16:43
 * @Version 1.0
 **/
public class reverse {
    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     **/
    public static int reverse(int x) {
        //取x最后一位
        int y = 0;
        while (x != 0) {
            System.out.println(x % 10);
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-569));
    }
}
