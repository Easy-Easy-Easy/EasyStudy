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
        return sourceArray;
    }

    public void mergeSort(int[] sourceArray, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //int mid = (left + right) / 2;
            System.out.printf("左半区 left: %s right %s%n", left, mid);
            //递归划分左半区
            mergeSort(sourceArray, left, mid, tmp);
            System.out.printf("右半区 left: %s right %s%n", mid + 1, right);
            //递归划分右半区
            mergeSort(sourceArray, mid + 1, right, tmp);
            //合并左半区和右半区
            merge(sourceArray, left, mid, right, tmp);
        }
    }

    public void merge(int[] sourceArray, int left, int mid, int right, int[] tmp) {
        //左半区第一个索引位置
        int l = left;
        //右半区第一个索引位置
        int r = mid + 1;
        //临时数组的下标（记录临时数组中存放数据的位置）
        int tmpPos = left;
        while (l <= mid && r <= right) {
            //以mid分割为两个内部已排好序的数组，
            //取出较小的元素，放在临时数组中
            if (sourceArray[l] < sourceArray[r]) {
                tmp[tmpPos] = sourceArray[l++];
            } else {
                tmp[tmpPos] = sourceArray[r++];
            }
            //临时数组的索引+1
            tmpPos++;
        }
        //左边数组剩余还有数据，把这个数组中所有数据放到临时数组
        while (l <= mid) {
            tmp[tmpPos++] = sourceArray[l++];
        }
        //右边数组剩余还有数据，把这个数组中所有数据放到临时数组
        while (r <= right) {
            tmp[tmpPos++] = sourceArray[r++];
        }
        //把临时数组中的元素放回原数组
        while (left <= right) {
            sourceArray[left] = tmp[left];
            left++;
        }
    }
}
