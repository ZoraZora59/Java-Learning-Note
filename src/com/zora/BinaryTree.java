package com.zora;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * <h3>Java-Learning-Note</h3>
 * <p>二叉树</p>
 *
 * @author : zora
 * @date : 2019/09/12
 */
public class BinaryTree {
    public static void main(String[] args) {
        BTree tree = build();
        System.out.println("前序遍历：");
        tree.DLR();
        System.out.println("\n中序遍历：");
        tree.LDR();
        System.out.println("\n后序遍历：");
        tree.LRD();
    }

    private static BTree build() {
        BTree root = new BTree("A");
        BTree point1 = new BTree("B");
        BTree point2 = new BTree("C");
        BTree point3 = new BTree("D");
        BTree point4 = new BTree("E");
        BTree point5 = new BTree("F");
        root.left = point1;
        root.right = point2;
        point1.left = point3;
        point1.right = point4;
        point2.left = point5;
        return root;
    }
}

/**
 * 二叉树
 */
class BTree {
    BTree(String call) {
        this.call = call;
    }

    private String call;
    BTree left;
    BTree right;

    /**
     * 前序遍历
     */
    void DLR() {
        System.out.print(call);
        if (left != null) {
            left.DLR();
        }
        if (right != null) {
            right.DLR();
        }
    }

    /**
     * 中序遍历
     */
    void LDR() {
        if (left != null) {
            left.LDR();
        }
        System.out.print(call);
        if (right != null) {
            right.LDR();
        }
    }

    /**
     * 后序遍历
     */
    void LRD() {
        if (left != null) {
            left.LRD();
        }
        if (right != null) {
            right.LRD();
        }
        System.out.print(call);
    }
}
