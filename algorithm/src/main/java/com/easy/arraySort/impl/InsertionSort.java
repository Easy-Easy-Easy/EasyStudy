package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName InsertionSort
 * @Description 插入排序
 * 思路：从1开始，第一次左边就一个元素，默认为已排序，
 * 在左边已排序的数组中，找到一个合适位置，将元素放在该位置
 * 代码实现：
 * 判断当前位置上的值，与前一个比较，小则交换两个数位置，
 * 在左边数组中不断循环以上操作
 * @Author zheng
 * @Date 2021/8/19 16:44
 * @Version 1.0
 **/
public class InsertionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        //找一个分界点，左边是已经排好序的数组
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            //左边的数组的最右边开始，为当前值找到一个合适的位置插入
            while (j >= 0 && sourceArray[j] > sourceArray[j + 1]) {
                int tmp = sourceArray[j];
                sourceArray[j] = sourceArray[j + 1];
                sourceArray[j + 1] = tmp;
                j--;
            }
        }
        return sourceArray;
    }
}
