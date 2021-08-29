package com.easy.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217 {
    //217. 存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num :nums){
            if (map.containsKey(num)){
                return true;
            }else {
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        return false;
    }
}
