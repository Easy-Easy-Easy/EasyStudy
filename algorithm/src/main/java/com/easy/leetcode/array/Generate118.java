package com.easy.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Generate118
 * @Description 118. 杨辉三角
 * @Author zheng
 * @Date 2021/9/1 11:48
 * @Version 1.0
 **/
public class Generate118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(tmp);
        }
        System.out.println(Arrays.toString(res.stream().toArray()));
        return res;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(dp[0][0]);
        res.add(tmp);
        for (int i = 1; i < numRows; i++) {
            tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                tmp.add(dp[i][j]);
            }
            res.add(tmp);
        }
        System.out.println(Arrays.toString(res.stream().toArray()));
        return res;
    }

    public static void main(String[] args) {
        Generate118 generate118 = new Generate118();
        generate118.generate1(5);
    }
}
