package com.easy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RomanToInt
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 18:24
 * @Version 1.0
 **/
public class RomanToInt {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return 1;
    }
}
