package com.zora;

/**
 * 在两个有序数组中找到中值，期望的时间复杂度为 O(log(m+n))
 *
 * @author Zora
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,1,2,3};
        int[] num2 = new int[]{1,5,6,7};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean mean = false;
        boolean culculate = false;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index = 1;
        double result=0;
        int midIndex;
        int index1=0,index2=0;
        double temp=0;
        if((length1 + length2)%2==0){
            //需要求平均数
            mean = true;
            midIndex = (length1+length2)/2;
        }else{
            //不需要求平均数
            mean = false;
            midIndex = (length1+length2)/2+1;

        }
        while(index <= midIndex){
            if(index1<length1 && index2<length2){
                if(nums1[index1]<=nums2[index2]){
                    result = nums1[index1];
                    index1++;
                }else{
                    result = nums2[index2];
                    index2++;
                }
            }else if(index1<length1){
                result = nums1[index1];
                index1++;
            }else{
                result = nums2[index2];
                index2++;
            }
            if(mean&&index == midIndex){
                index--;
                mean = false;
                temp = result;
                culculate = true;
            }
            index++;
        }
        if(culculate){
            result = (result + temp)/2;
        }
        return result;
    }
}
