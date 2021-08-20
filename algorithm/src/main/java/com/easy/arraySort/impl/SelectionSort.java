package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName SelectionSort
 * @Description 选择排序
 * 思路：以i为分界岭，从大于i的这一侧，找出最小值对应的索引，与索引i上的数据进行交换
 * @Author zheng
 * @Date 2021/8/19 15:39
 * @Version 1.0
 **/
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            for (int j = i + 1; j < sourceArray.length; j++) {
                int min = i;
                if (sourceArray[min] > sourceArray[j]) {
                    min = j;
                }
                if (min != i) {
                    int tmp = sourceArray[i];
                    sourceArray[i] = sourceArray[min];
                    sourceArray[min] = tmp;
                }
            }
        }
        return sourceArray;
    }
}
