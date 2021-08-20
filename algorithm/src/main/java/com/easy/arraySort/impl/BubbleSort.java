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
            //注意j的值，j=sourceArray.length - i，因为每次排序后，最后一个值一定是数组的最大值/最小值
            for (int j = 0; j < sourceArray.length - i; j++) {
                //依次比较相邻的值，并把大的数据向后交换，内循环完成后，最后一次的位置一定是本次循环的最大值
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
