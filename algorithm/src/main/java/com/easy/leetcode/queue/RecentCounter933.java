package com.easy.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter933 {
    Queue<Integer> queue;
    public RecentCounter933() {
        queue= new ArrayDeque();
    }

    public int ping(int t) {
        queue.offer(t);
        while (t-3000>queue.peek()){
            queue.poll();
        }
        return queue.size();
    }
}
