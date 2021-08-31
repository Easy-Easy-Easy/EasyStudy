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
        int size = 10;
        int[] sourceArray = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            sourceArray[i] = random.nextInt(100);
        }
        sourceArray = new int[]{
                34, 32, 73, 82, 56, 48, 78, 58, 66, 60
        };
        System.out.println(Arrays.toString(sourceArray));
        System.out.println("-------------------------------------");
        //int[] sourceArray = new int[]{5, 7, 3, 4, 2};
        //IArraySort iArraySort = new BubbleSort();
        //IArraySort iArraySort = new SelectionSort();
        //IArraySort iArraySort = new InsertionSort();
        //IArraySort iArraySort = new ShellSort();
        //IArraySort iArraySort = new MergeSort();
        IArraySort iArraySort = new QuickSort();
        //IArraySort iArraySort = new HeapSort();
        //IArraySort iArraySort = new CountingSort();
        System.out.println(Arrays.toString(iArraySort.sort(sourceArray)));
    }
}
