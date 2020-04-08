package com.rulinzi.arr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Department:  研发部
 * Title:       [com.rulinzi.arr — 模块名]
 * Description: [描述该类概要功能]
 * Created on   2020/4/8 17:36
 * @version 1.0
 */
public class LCArray {
    /**
     * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     **/
    public int[] twoSum(int[] nums, int target) {
        int[] arrs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i==j){
                    continue;
                }
                if(nums[i]+nums[j]==target){
                    arrs[0]=i;
                    arrs[1]=j;
                    return arrs;
                }
            }
        }
        return  null;
    }
    /**
     * @Description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     *
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     *
     * 你可以假设 nums1 和 nums2 不会同时为空。[1,3,4,5] [1,2,3,4]
     * @Date:
     **/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length-i; j++) {
                if (nums1[i]>=nums2[j]){
                    list.add(nums2[j]);
                }
            }

            list.add(nums1[i]);
        }

        return 3.5;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1,2,3,4};
        int[] y = new int[]{2,3,4};
        findMedianSortedArrays(x,y);
    }

}
