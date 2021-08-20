package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

/**
 * @ClassName ShellSort
 * @Description 希尔排序
 * 思路：变相的插入排序
 * 选取一个步长（一般为数组长度/2），分组，组内排序，
 * 步长再除以2，再次排序，至到步长为0
 * @Author zheng
 * @Date 2021/8/19 18:18
 * @Version 1.0
 **/
public class ShellSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int step = length;
        //以不同的步长分组，在组内排序
        while ((step = step / 2) > 0) {
            for (int i = step; i < length; i++) {
                int j = i - step;
                while (j >= 0 && sourceArray[j] > sourceArray[j + step]) {
                    int tmp = sourceArray[j];
                    sourceArray[j] = sourceArray[j + step];
                    sourceArray[j + step] = tmp;
                    j = j - step;
                }
            }
        }

        return sourceArray;
    }
}
