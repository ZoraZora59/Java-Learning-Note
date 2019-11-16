//package com.zora;
//
//import com.sun.tools.javac.code.Attribute;
//
//import java.lang.reflect.Array;
//
///**
// * <h3>Java-Learning-Note</h3>
// * <p>大数组快速排序</p>
// *
// * @author : zora
// * @date : 2019/10/16
// */
//public class LargeArray {
//    public static void main(String[] args) {
//        int[] largeIntArray = new int[1000000];
//
//    }
//}
//
//class Solution {
//        int thirdMax (vector<int> & nums) {
//        int nSize = nums.size();
//        if (0 == nSize) {
//            return -1;
//        } else if (1 == nSize) {
//            return nums[0];
//        } else if (2 == nSize) {
//            return nums[0] > nums[1] ? nums[0] : nums[1];
//        }
//
//        int nMax = -2147483648;
//        int nSec = -2147483648;
//        int nThird = -2147483648;
//        bool bRes = false;
//        int count = nSize;
//
//        for (int i = 0; i < nSize; i++) {
//            if (nums[i] == -2147483648 && !bRes) {
//                bRes = true;
//                continue;
//            }
//            if (nMax == nums[i] || nSec == nums[i] || nThird == nums[i]) {
//                count--;
//            }
//
//            if (nMax < nums[i]) {
//                nThird = nSec;
//                nSec = nMax;
//                nMax = nums[i];
//            } else if (nSec < nums[i] && nMax != nums[i]) {
//                nThird = nSec;
//                nSec = nums[i];
//            } else if (nThird < nums[i] && nSec != nums[i] && nMax != nums[i]) {
//                nThird = nums[i];
//            }
//        }
//
//
//        if (count >= 3) {
//            return nThird;
//        }
//        return nMax;
//    }
//    }
//}