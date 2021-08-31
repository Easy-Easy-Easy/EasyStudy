package com.easy.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName FindMedianSortedArrays
 * @Description 4.寻找两个正序数组的中位数
 * @Author zheng
 * @Date 2021/8/30 14:49
 * @Version 1.0
 **/
public class FindMedianSortedArrays4 {
    /**
     * @return double
     * @Description 寻找两个正序数组的中位数
     * @Date 2021/8/30 14:58
     * @Param [nums1, nums2]
     **/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] sorted = new int[m + n];
        System.arraycopy(nums1, 0, sorted, 0, m);
        System.arraycopy(nums2, 0, sorted, m, n);
        Arrays.sort(sorted);
        if ((m + n) % 2 == 0) {
            return (double) (sorted[(m + n) / 2] + sorted[(m + n) / 2 - 1]) / 2;
        } else {
            return (double) sorted[(m + n) / 2];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{
                1, 2
        };
        int[] num2 = new int[]{
                3, 4
        };
        System.out.println(findMedianSortedArrays(num1,num2));
    }
}
