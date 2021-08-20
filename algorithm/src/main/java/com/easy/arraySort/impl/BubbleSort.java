package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序
 * 思路：不停地交换
 * 交换相邻的数，大数向后换
 * @Author zheng
 * @Date 2021/8/19 15:13
 * @Version 1.0
 **/
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        for (int i = 1; i < sourceArray.length; i++) {
            for (int j = 0; j < sourceArray.length - i; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    int tmp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + 1];
                    sourceArray[j + 1] = tmp;
                }
            }
        }
        return sourceArray;
    }
}
