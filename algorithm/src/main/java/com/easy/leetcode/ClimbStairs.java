package com.easy.leetcode;

/**
 * @ClassName ClimbStairs
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/12 17:14
 * @Version 1.0
 **/
public class ClimbStairs {

    /**
     * //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     **/
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 最大子序和
     * <p>
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     **/
    public int maxSubArray(int[] nums) {
        //最大值
        int max = nums[0];
        //以某个索引位置结尾的最大和
        int sub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sub = sub > 0 ? sub + nums[i] : nums[i];
            max = Math.max(max, sub);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        //最大子序和 start
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        climbStairs.maxSubArray(nums);
        //最大子序和 end
    }
}
