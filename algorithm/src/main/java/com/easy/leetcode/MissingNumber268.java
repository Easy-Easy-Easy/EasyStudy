package com.easy.leetcode;
//268. 丢失的数字
public class MissingNumber268 {
    /**
     * 268. 丢失的数字
     * 思路：减法，最后计算的值就是缺失的数
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int total=(1+nums.length)*nums.length/2;
        for (int i = 0; i < nums.length; i++) {
            total=total-nums[i];
        }
        return total;
    }
}
