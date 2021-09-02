package com.easy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SetZeroes
 * @Description 73. 矩阵置零
 * @Author zheng
 * @Date 2021/9/2 17:25
 * @Version 1.0
 **/
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> columnMap = new HashMap<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0) {
                    rowMap.put(i, 0);
                    columnMap.put(j, 0);
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (rowMap.containsKey(i) || columnMap.containsKey(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
