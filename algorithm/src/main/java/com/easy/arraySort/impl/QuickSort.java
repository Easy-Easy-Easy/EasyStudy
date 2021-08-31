package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * 思路：先找基准点，假定基准点为数组的left值
 * 从left 到right遍历，找比基准点的值小的值，
 * 记录最小值的位置，每次找到比基准点小的值，则交换最小值位置上的数，
 * 并将最小值对应的位置向后移一位，
 * 当整个数组遍历完成后，最小值对应的位置之前的数字，都一定比基准点小，
 * @Author zheng
 * @Date 2021/8/20 14:53
 * @Version 1.0
 **/
public class QuickSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        quickSort(sourceArray, 0, sourceArray.length - 1);
        return sourceArray;
    }

    private void quickSort(int[] sourceArray, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(sourceArray, left, right);
            quickSort(sourceArray, left, partitionIndex - 1);
            quickSort(sourceArray, partitionIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        //基准点
        int pivot = left;
        int j = pivot + 1;
        //此处right是索引值，所以是小于等于
         for (int i = j; i <= right; i++) {
            //找到比基准点小的值，则交换
            if (arr[i] < arr[pivot]) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, pivot, j - 1);
        return j - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
