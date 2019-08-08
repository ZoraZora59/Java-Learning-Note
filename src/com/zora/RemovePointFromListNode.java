package com.zora;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 单向链表删除指定节点
 * <p>
 * leetcode（国内版）第19题
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5
 *
 * @author Zora
 */
public class RemovePointFromListNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        while (n>0){
            n--;
            fastPoint=fastPoint.next;
            if(fastPoint==null){
                return head.next;
            }
        }
        while (fastPoint.next!=null){
            fastPoint=fastPoint.next;
            slowPoint=slowPoint.next;
        }
        slowPoint.next=slowPoint.next.next;
        return head;
    }

    public static void main(String[] args) {
        int cutPoint = 2;
        int[] array = {1, 22};
        List<Integer> list = new ArrayList<>();
        ListNode starter = new ListNode(0);
        ListNode point = starter;
        for (int value : array) {
            point.next = new ListNode(value);
            point = point.next;
        }
        ListNode result = new RemovePointFromListNode().removeNthFromEnd(starter.next, cutPoint);
        while (result.next != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.print(result.val);
    }
}
