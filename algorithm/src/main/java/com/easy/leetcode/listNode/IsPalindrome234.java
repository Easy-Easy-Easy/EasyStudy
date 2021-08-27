package com.easy.leetcode.listNode;

import com.easy.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IsPalindrome234
 * @Description 234. 回文链表
 * @Author zheng
 * @Date 2021/8/26 20:24
 * @Version 1.0
 **/
public class IsPalindrome234 {
    /**
     * @return boolean
     * @Description 234. 回文链表
     * @Date 2021/8/26 20:32
     * @Param [head]
     **/
    public boolean isPalindrome(ListNode head) {
        List<Integer> lst = new ArrayList<>();
        while (head != null) {
            lst.add(head.val);
            head = head.next;
        }
        int start = 0, end = lst.size() - 1;
        while (start < end) {
            if (!lst.get(start).equals(lst.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
