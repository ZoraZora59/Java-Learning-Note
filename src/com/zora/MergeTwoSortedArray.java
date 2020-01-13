package com.zora;

/**
 * <h3>Java-Learning-Note</h3>
 * <h4>com.zora</h4>
 * <p>合并两个有序链表</p>
 *
 * @author : zora
 * @since : 2019/12/23
 */
public class MergeTwoSortedArray {
    ListNode l1 ,l2;
    public static void main(String[] args) {
        MergeTwoSortedArray clz=new MergeTwoSortedArray();
        clz.init();
        ListNode head =clz.mergeTwoLists();
        clz.print(head);
    }

    void init(){
        l1 = new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(7);
        l2 = new ListNode(1);
        l2.next=new ListNode(2);
        l2.next.next=new ListNode(5);
    }
    void print(ListNode head){
        System.out.println("Should be:\n1->1->2->3->5->7->\nAnswer is:");
        while (head!=null){
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists() {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode head, current;
        if (l1.val >= l2.val) {
            head = l2;
            l2=l2.next;
        } else {
            head = l1;
            l1=l1.next;
        }
        current = head;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current=current.next;
        }
        if(l1==null){
            current.next=l2;
        }else {
            current.next=l1;
        }
        return head;

    }
}
