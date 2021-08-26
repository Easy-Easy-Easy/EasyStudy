package com.easy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCodeOne2Ten
 * @Description leetcode 前10题
 * @Author zheng
 * @Date 2021/8/18 9:54
 * @Version 1.0
 **/
public class LeetCodeOne2Ten {
    /**
     *
     * 1.给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案
     **/
    /**
     * 思路：Map法
     * Map中key 对应的是数组中的值，value 是对应的索引
     * 遍历数组，从map获取target-数组对应位置的值，存在返回两个索引
     * 不存在则把这个值加入到map 中
     **/
    public int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> map = new HashMap(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * 2.两数字相加
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     **/

    /**
     * 思路:
     * 1.遍历两个链表，对应位置上的值相加
     * 2.两个链表全部遍历完毕且进位为0时停止
     * 3.对应位置上是null时，此位置的值对应为0
     * 4.相加的和大于9，进位为1，否则为0
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位
        int carry = 0;
        //和
        int sum = 0;
        int val1 = 0;
        int val2 = 0;
        //返回值
        ListNode listNode = new ListNode(0);
        ListNode tmp = listNode;
        while (l1 != null || l2 != null || carry != 0) {
            val1 = l1 == null ? 0 : l1.val;
            val2 = l2 == null ? 0 : l2.val;
            sum = val1 + val2 + carry;
            if (sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
        }
        return listNode.next;
    }

    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     **/

    /**
     * 思路：滑动窗口
     * 两个指针，分别代表窗口的左右边界
     * Map 存放字符对应的索引位置
     * 移动右指针，判断map中是否存在，不存在则加入到map中，
     * 存在则查找该字符所在位置（注意：该值必须在left指针的右边）
     **/
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

}


