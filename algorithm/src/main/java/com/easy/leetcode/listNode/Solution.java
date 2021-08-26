package com.easy.leetcode.listNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Solution
 * @Description 链表
 * @Author zheng
 * @Date 2021/8/25 16:46
 * @Version 1.0
 **/
public class Solution {
    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 206 反转链表
     * @Date 2021/8/25 17:14
     * @Param [head]
     **/
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    /**
     * @return boolean
     * @Description 141:是否存在环形链表
     * @Date 2021/8/25 17:14
     * @Param [head]
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode quick = head.next.next;
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            } else {
                slow = slow.next;
                quick = quick.next.next;
            }
        }
        return false;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 21 合并两个有序链表
     * @Date 2021/8/25 17:34
     * @Param [l1, l2]
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        //两个链表均不为空
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        //l1不为空
        if (l1 != null) {
            tmp.next = l1;
        }
        //l2 不为空
        if (l2 != null) {
            tmp.next = l2;
        }
        return head.next;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 21 合并两个有序链表 递归
     * @Date 2021/8/25 17:55
     * @Param [l1, l2]
     **/
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 19. 删除链表的倒数第 N 个结点
     * @Date 2021/8/26 9:38
     * @Param [head, n]
     **/
    public ListNode removeNthFromEndStack(ListNode head, int n) {
        head = new ListNode(0, head);
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        int count = 0;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            count++;
            if (count == n + 1) {
                node.next = node.next.next;
                break;
            }
        }
        return head.next;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 19. 删除链表的倒数第 N 个结点
     * @Date 2021/8/26 9:38
     * @Param [head, n]
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = new ListNode(0, head);
        int count = 0;
        ListNode pre = head;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            if (count == n) {
                pre = pre.next;
            } else {
                count++;
            }

        }
        pre.next = pre.next.next;
        return head.next;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 876. 链表的中间结点
     * @Date 2021/8/26 14:21
     * @Param [head]
     **/
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode quick = head, slow = head;
        while (quick != null) {
            quick = quick.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
        }
        return slow;
    }

    /**
     * @return com.easy.leetcode.listNode.ListNode
     * @Description 876. 链表的中间结点
     * @Date 2021/8/26 14:21
     * @Param [head]
     **/
    public ListNode middleNode1(ListNode head) {
        ListNode slow = head, quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        for (int i = 1; i < 6; i++) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }
        Solution solution = new Solution();
        solution.removeNthFromEnd(node.next, 2);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
