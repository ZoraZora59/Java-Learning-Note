package com.zora;

/**
 * <h3>Java-Learning-Note</h3>
 * <h4>PACKAGE_NAME</h4>
 * <p>合并两个有序数组</p>
 *
 * @author : zora
 * @since : 2019/12/05
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,7};
        int[] b = new int[]{2,3,6};
        int[] c  = merge(a,b);
        for (int i : c) {
            System.out.println(i);
        }
    }
    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        function(a,b,c,0,0,0);
        return c;
    }
    static void function(int[] a,int[] b,int[] c,int indexA,int indexB,int indexC){
        while (indexA < a.length || indexB < b.length) {
            if (indexA >= a.length) {
                c[indexC] = b[indexB];
                indexB++;
            } else if (indexB >= b.length) {
                c[indexC] = a[indexA];
                indexA++;
            } else if (a[indexA] >= b[indexB]) {
                c[indexC] = b[indexB];
                indexB++;
            } else {
                c[indexC] = a[indexA];
                indexA++;
            }
            indexC++;
        }
    }
}
