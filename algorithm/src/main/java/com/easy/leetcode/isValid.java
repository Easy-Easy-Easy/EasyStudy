package com.easy.leetcode;

import java.util.Stack;

/**
 * @ClassName isValid
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 19:49
 * @Version 1.0
 **/
public class isValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     **/
    public static boolean isValid(String str) {
        if (str == null || str == "" || str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('(' == c) {
                stack.push(')');
            } else if ('[' == c) {
                stack.push(']');
            } else if ('{' == c) {
                stack.push('}');
            } else if (stack.isEmpty()) {
                return false;
            } else if (stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()";
        System.out.println(isValid(str));
    }
}
