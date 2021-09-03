package com.easy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstUniqChar387
 * @Description 387. 字符串中的第一个唯一字符
 * @Author zheng
 * @Date 2021/9/3 17:48
 * @Version 1.0
 **/
public class FirstUniqChar387 {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
