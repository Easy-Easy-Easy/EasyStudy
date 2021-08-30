package com.easy.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName Merge88
 * @Description 88. 合并两个有序数组
 * @Author zheng
 * @Date 2021/8/30 9:38
 * @Version 1.0
 **/
public class Merge88 {
    /**
     * @return void
     * @Description 88. 合并两个有序数组
     * @Date 2021/8/30 9:39
     * @Param [nums1, m, nums2, n]
     **/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * @return void
     * @Description 88. 合并两个有序数组
     * @Date 2021/8/30 9:46
     * @Param [nums1, m, nums2, n]
     **/
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] sorted = new int[m + n];
        int i = 0;
        int j = 0;
        int len = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                sorted[len] = nums1[i];
                i++;
            } else {
                sorted[len] = nums2[j];
                j++;
            }
            len++;
        }
        while (i < m) {
            sorted[len] = nums1[i];
            i++;
            len++;
        }
        while (j < n) {
            sorted[len] = nums2[j];
            j++;
            len++;
        }
        nums1 = sorted;
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * @return void
     * @Description 88. 合并两个有序数组
     * @Date 2021/8/30 9:46
     * @Param [nums1, m, nums2, n]
     **/
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{
                1, 2, 3, 0, 0, 0,
        };
        int[] num2 = new int[]{
                2, 5, 6
        };
        merge2(num1, 3, num2, 3);
    }
}
