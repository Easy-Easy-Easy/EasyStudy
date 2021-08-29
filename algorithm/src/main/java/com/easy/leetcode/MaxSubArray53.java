package com.easy.leetcode;
//53. 最大子序和
public class MaxSubArray53 {
    /**
     * 53. 最大子序和
     * 思路：
     * 如果前面的值加起来，比当前值还小，就把前面的值抛弃掉，从这个值开始累加
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum =nums[0];
        int ans=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            sum=sum+nums[i]>nums[i]?sum+nums[i]:nums[i];
            ans= ans>sum?ans:sum;
        }
        return ans;
    }
}
