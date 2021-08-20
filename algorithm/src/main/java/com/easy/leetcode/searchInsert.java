package com.easy.leetcode;

/**
 * @ClassName searchInsert
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/10 19:10
 * @Version 1.0
 **/
public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        //System.out.println(mid);
        return nums[mid] > target ? mid : mid + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }
}
