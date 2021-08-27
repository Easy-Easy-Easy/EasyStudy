package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

/**
 * @ClassName GetDecimalValue1290
 * @Description 1290. 二进制链表转整数
 * @Author zheng
 * @Date 2021/8/26 20:55
 * @Version 1.0
 **/
public class GetDecimalValue1290 {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = sum * 2 + head.val;
            head = head.next;
        }
        return sum;
    }

}
