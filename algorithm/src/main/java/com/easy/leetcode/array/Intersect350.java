package com.easy.leetcode.array;

import java.util.*;

/**
 * @ClassName Intersect350
 * @Description 350. 两个数组的交集 II
 * @Author zheng
 * @Date 2021/9/1 10:38
 * @Version 1.0
 **/
public class Intersect350 {
    /**
     * @return int[]
     * @Description 350. 两个数组的交集 II
     * @Date 2021/9/1 10:38
     * @Param [nums1, nums2]
     **/
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num :
                nums1) {
            int count = countMap.getOrDefault(num, 0) + 1;
            countMap.put(num, count);
        }
        List<Integer> lst = new ArrayList<>();
        for (int num :
                nums2) {
            int count = countMap.getOrDefault(num, 0);
            if (count > 0) {
                lst.add(num);
                countMap.put(num, count - 1);
            }
        }
        return lst.stream().mapToInt(Integer::valueOf).toArray();
    }

    /**
     * @return int[]
     * @Description 350. 两个数组的交集 II
     * @Date 2021/9/1 10:38
     * @Param [nums1, nums2]
     **/
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> lst = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                lst.add(nums1[i]);
                i++;
                j++;
            }
        }
        return lst.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 9, 5};
        int[] num2 = new int[]{
                9, 4, 9, 8, 4};
        Intersect350 intersect350 = new Intersect350();

        System.out.println(Arrays.toString(intersect350.intersect1(num1, num2)));
    }
}
