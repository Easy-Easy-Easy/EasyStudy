package com.easy.leetcode;

/**
 * @ClassName RemoveDuplicates
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/4 17:12
 * @Version 1.0
 **/
public class RemoveDuplicates {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
     **/
    public int removeDuplicates(int[] nums) {
        //双指针
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        for (int i = 0; i < removeElement(arr, 3)-1; i++) {
            System.out.println(arr[i]);
        }

    }
}
