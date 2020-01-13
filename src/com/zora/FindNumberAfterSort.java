package com.zora;


/**
 * <h3>Java-Learning-Note</h3>
 * <h4>com.zora</h4>
 * <p>找出数组中第n大的奇数</p>
 * 查找数组arr中第k大的奇数,如果不存在则返回0. (arr[i] > 0 (i>=0))
 * 计算出时间复杂度
 * (注意代码注释，不要使⽤库函数或脚本中已经实现好的排序算法和⼯具, 需要⾃⼰实现数据结构和所需要的算法)
 * 关键词： 数组    第k大的    奇数    非法输入和未找到则返回0
 * <p>思路：转换到二叉排序树，中序遍历导出第n个</p>
 * <p>核心代码段：25-47,87-95,161-172.</p>
 * 其余部分为数据结构实现
 *
 * @author : zora
 * @since : 2019/12/21
 */
public class FindNumberAfterSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 6, 2, 8, 7, 11};
        int k = 2;
        int result = findKth(array, k);
        System.out.println("Output :" + result);
    }

    public static int findKth(int[] arr, int k) {
        // 处理非法输入
        if (k > arr.length) {
            return 0;
        }
        //二叉排序树
        BSTree bsTree = new BSTree();
        // 遍历 复杂度 O(logN) ~ O(N)，取决于二叉排序树平衡性
        for (int num : arr) {
            // 奇偶判断
            if (num % 2 != 0) {
                // 写入树
                bsTree.push(num);
            }
        }
        // 树中节点个数无法满足目标序数
        if (bsTree.size() < k) {
            return 0;
        } else {
            // 取二叉排序树中的第k个 复杂度 O(N)
            return bsTree.get(k);
        }
    }
}

/**
 * 树节点
 */
class TreeNode {
    TreeNode(int val) {
        this.val = val;
    }

    private int val;
    TreeNode left;
    TreeNode right;

    /**
     * 插入新节点
     *
     * @param value 节点数值
     */
    void insert(int value) {
        //左节点>=中间节点>右节点
        if (value >= val) {
            if (left == null) {
                left = new TreeNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    /**
     * 中序遍历
     */
    void LDR(LinkedList list) {
        if (left != null) {
            left.LDR(list);
        }
        list.add(val);
        if (right != null) {
            right.LDR(list);
        }
    }
}

/**
 * 链表节点
 */
class ListNode {
    ListNode(int value) {
        val = value;
    }

    int val;
    ListNode next;
}

/**
 * 单向链表
 */
class LinkedList {
    ListNode head;
    ListNode tail;

    /**
     * 链表尾插入节点
     *
     * @param val 节点值
     */
    void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    }
}

/**
 * 反二叉排序树，左>右
 */
class BSTree {
    private TreeNode root;
    private int size = 0;

    /**
     * 压入
     *
     * @param value 新节点值
     */
    void push(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
        size++;
    }

    /**
     * 取第n大的数
     *
     * @param index 第index大的数
     * @return 数值
     */
    int get(int index) {
        LinkedList list = new LinkedList();
        root.LDR(list);
        int result = 0;
        ListNode node = list.head;
        while (index != 0) {
            result = node.val;
            node = node.next;
            index--;
        }
        return result;
    }

    /**
     * 获取树的总节点个数
     *
     * @return 总节点个数
     */
    int size() {
        return size;
    }
}
