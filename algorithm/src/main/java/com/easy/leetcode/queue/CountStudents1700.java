package com.easy.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * 1700. 无法吃午餐的学生数量
 */
public class CountStudents1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        if (sandwiches==null||sandwiches.length==0) {
            return students==null?0:students.length;
        }
        Stack<Integer> sandwichesStack= new Stack<Integer>();
        for (int i = sandwiches.length-1; i >=0 ; i--) {
            sandwichesStack.push(sandwiches[i]);
        }
        Queue<Integer> studentQueue = new ArrayDeque<Integer>();
        for (int student : students) {
            studentQueue.offer(student);
        }
        int count=0;
        int studentNum= studentQueue.size();
        while (!sandwichesStack.isEmpty()&&count<studentNum){
            if (sandwichesStack.peek()==studentQueue.peek()) {
                sandwichesStack.pop();
                studentQueue.poll();
                studentNum--;
                count=0;
            }else {
               studentQueue.offer(studentQueue.poll());
                count++;
            }
        }
        return sandwichesStack.size();
    }

    /**
     * 数组解法
     * 思路：学生一直会排队，所以学生的顺序不重要
     * 三明治的顺序很重要，如果当前类型的三明治，没有学生喜欢了，那么接下来就会陷入死循环，后面的学生永远拿不到喜欢的三明治了
     * 此时返回剩余三明治数量即可
     * @param students
     * @param sandwiches
     * @return
     */
    public static int countStudents2(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        int num =students.length;
        for (int i = 0; i < num; i++) {
            count[students[i]]++;
        }
        for (int i = 0; i <num ; i++) {
            if (count[sandwiches[i]]>0){
                count[sandwiches[i]]--;
            }else {
                return num-i;
            }
        }
        return 0;

    }
    public static void main(String[] args) {
        int[] students= new int[]{1,1,1,0,0,1};
        int[] sandwiches = new int[]{1,0,0,0,1,1};
        //System.out.println( countStudents(students,sandwiches));
        System.out.println(countStudents2(students,sandwiches));
    }
}
