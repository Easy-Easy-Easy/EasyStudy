package com.easy.arraySort.impl;

import com.easy.arraySort.IArraySort;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName CountingSort
 * @Description 计数排序
 * 思路：适合整数数组
 * 求数组中元素的最大值
 * 创建一个辅助数组，用来存储从0 到最大值+1的,value为该值出现的次数
 * 遍历该数组，如果出现的次数大于0，则向原数组中存储一次，遍历完成后，则完成排序
 * @Author zheng
 * @Date 2021/8/23 10:55
 * @Version 1.0
 **/
public class CountingSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        //最大值
        int max = Arrays.stream(sourceArray).max().getAsInt();
        //创建一个数组
        int[] tmp = new int[max + 1];
        //记录每一个value出现的次数
        for (int value :
                sourceArray) {
            tmp[value]++;
        }
        int length = max + 1;
        int j = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i]-- > 0) {
                sourceArray[j++] = i;
            }
        }
        return sourceArray;
    }
}
