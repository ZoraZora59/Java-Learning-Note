package com.zora;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>链表反转</p>
 *
 * @author : zora
 * @date : 2019/11/16
 */
public class LinkedNodeReverse {
    public static void main(String[] args) {
        LinkNode node = init();
        iterPrint(node);
        node = reverse(node);
        iterPrint(node);
    }

    /**
     * 链表反转
     *
     * @param firstNode 原头节点
     * @return 新头节点
     */
    private static LinkNode reverse(LinkNode firstNode) {
        if (firstNode.next == null) {
            return firstNode;
        }
        LinkNode iterNode = firstNode;
        LinkNode tempNode = firstNode.next;
        firstNode.next = null;
        while (tempNode != null) {
            LinkNode preNode = iterNode;
            iterNode = tempNode;
            tempNode = iterNode.next;
            iterNode.next = preNode;
        }
        return iterNode;
    }

    /**
     * 遍历打印
     *
     * @param firstNode 头节点
     */
    private static void iterPrint(LinkNode firstNode) {
        LinkNode iterNode = firstNode;
        while (iterNode != null) {
            if (iterNode.next == null) {
                System.out.print(iterNode.value);
            } else {
                System.out.print(iterNode.value + "->");
            }
            iterNode = iterNode.next;
        }
        System.out.println();
    }

    /**
     * 初始化链表
     *
     * @return 链表头节点
     */
    private static LinkNode init() {
        int i = 5;
        LinkNode firstNode = new LinkNode(i);
        LinkNode thisNode = firstNode;
        while (i != 0) {
            i--;
            thisNode.next = new LinkNode(i);
            thisNode = thisNode.next;
        }
        return firstNode;
    }
}

//节点
class LinkNode {
    int value;
    LinkNode next;

    LinkNode(int value) {
        this.value = value;
    }
}
