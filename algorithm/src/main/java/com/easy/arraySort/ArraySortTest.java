package com.easy.arraySort;

import com.easy.arraySort.impl.*;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName ArraySortTest
 * @Description TODO
 * @Author zheng
 * @Date 2021/8/19 15:21
 * @Version 1.0
 **/
public class ArraySortTest {
    public static void main(String[] args) {
        int[] sourceArray = new int[50];
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            sourceArray[i] =random.nextInt(100);
        }
        //int[] sourceArray = new int[]{5, 7, 3, 4, 2};
        //IArraySort iArraySort = new BubbleSort();
        //IArraySort iArraySort = new SelectionSort();
        //IArraySort iArraySort = new InsertionSort();
        //IArraySort iArraySort = new ShellSort();
        IArraySort iArraySort = new MergeSort();
        System.out.println(Arrays.toString(iArraySort.sort(sourceArray)));
    }
}
