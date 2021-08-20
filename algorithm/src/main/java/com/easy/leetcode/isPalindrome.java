package com.easy.leetcode;

/**
 * @ClassName isPalindrome
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 17:07
 * @Version 1.0
 **/
public class isPalindrome {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     **/
    public static boolean isPalindrome(int x) {
        int tmp = x;
        if (x < 0) {
            return false;
        }
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return tmp == y;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
