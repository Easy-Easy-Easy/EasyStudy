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
            //以i为分界点，左边是排好序，右边是未排序的
            for (int j = i + 1; j < sourceArray.length; j++) {
                //先假定i位置为最小值所在的位置
                int min = i;
                //如果右边的数组中有比i对应位置上的数更小的，那么久更新最小值对应的索引
                if (sourceArray[min] > sourceArray[j]) {
                    min = j;
                }
                //最小值索引不是i,那么就已经从右边选择出了最小值，交换i与最小值对应位置上的值
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
