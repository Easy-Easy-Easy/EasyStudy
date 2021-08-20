package com.easy.leetcode;

/**
 * @ClassName LongestCommonPrefix
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 18:54
 * @Version 1.0
 **/
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     **/
    public static String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (String str :
                strs) {
            while (!str.startsWith(commonPrefix)) {
                if(commonPrefix.length()==0){
                    return "";
                }
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
