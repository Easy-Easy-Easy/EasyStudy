package com.easy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TwoSum
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/3 16:10
 * @Version 1.0
 **/
public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * @return int[]
     * @Description //TODO
     * @Date 2021/8/3 16:11
     * @Param [nums, target]
     **/
    public static int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        throw new Exception("没有匹配的数字");
    }

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2, 3, 7, 9};
        int[] res = twoSum(nums, 9);
        System.out.println("res = " + Arrays.toString(res));
    }
}
