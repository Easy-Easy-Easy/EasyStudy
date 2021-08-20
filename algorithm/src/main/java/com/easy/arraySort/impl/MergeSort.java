package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/19 20:35
 * @Version 1.0
 **/
public class MergeSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int[] tmp = new int[length];
        mergeSort(sourceArray, 0, length - 1, tmp);
        return new int[0];
    }

    public void mergeSort(int[] sourceArray, int left, int right, int[] tmp) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(sourceArray, left, mid, tmp);
            mergeSort(sourceArray, mid + 1, right, tmp);

        }
    }

    public void merge(int[] sourceArray, int left, int mid, int right, int[] tmp) {

    }
}
