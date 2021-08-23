package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName HeapSort
 * @Description 堆排序
 * 思路：构造一个大顶推
 * 三个节点的关系
 * 假设父节点下标为i，
 * 左子节点下标为i*2 +1
 * 右子节点下标为2*i+2
 * <p>
 * 假设子节点下标为i
 * 父节点下标为 i/2-1;
 *
 *
 * @Author zheng
 * @Date 2021/8/22 9:24
 * @Version 1.0
 **/
public class HeapSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        //先把数组转换成一个大顶堆
        buildMaxHeap(sourceArray);
        int len = sourceArray.length;
        for (int i = len - 1; i > 0; i--) {
            //把大顶推的最大值取出来，放在最后
            swap(sourceArray, 0, i);
            len--;
            //以第一个元素，再构造一个大顶推
            heaify(sourceArray, len, 0);
        }
        return sourceArray;
    }

    /**
     * @return void
     * @Description 构造一个大顶堆
     * @Date 2021/8/22 12:45
     * @Param [sourceArray]
     **/
    public void buildMaxHeap(int[] sourceArray) {
        int length = sourceArray.length;
        //最后一个待维护的堆顶元素下标
        int m = length / 2 - 1;
        for (int i = m; i >= 0; i--) {
            heaify(sourceArray, length, i);
        }
    }

    /**
     * @return
     * @Description 建堆
     * @Date 2021/8/22 10:15
     * @Param 待维护数组，数组的长度，待维护节点的索引
     **/
    public void heaify(int[] sourceArray, int n, int i) {
        //待维护的大顶堆节点下标
        int max = i;
        // 待维护节点的左节点
        int left = i * 2 + 1;
        // 待维护节点的右节点
        int right = i * 2 + 2;
        //从三个节点中找出最大值，与大顶堆的顶部节点交换
        if (left < n && sourceArray[left] > sourceArray[max]) {
            max = left;
        }
        if (right < n && sourceArray[right] > sourceArray[max]) {
            max = right;
        }
        if (max != i) {
            swap(sourceArray, max, i);
            heaify(sourceArray, n, max);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
