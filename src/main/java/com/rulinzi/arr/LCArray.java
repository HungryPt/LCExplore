package com.rulinzi.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l = l1+l2;
        if((l&0x01)==0){//中位数为两数之平均数的情况
            int index1 = l/2;
            int index2 = l/2-1;
            int sum1=0;
            int sum2=0;
            int i=0;
            int j=0;
            int x=0;
            while(i<l1||j<l2){
                if(i>=l1){
                    if(x==index1){
                        sum1=nums2[j];
                    }
                    if(x==index2){
                        sum2=nums2[j];
                    }

                    j++;
                }else if(j>=l2){
                    if(x==index1){
                        sum1=nums1[i];
                    }
                    if(x==index2){
                        sum2=nums1[i];
                    }

                    i++;
                }
                else if(nums1[i]<nums2[j]){
                    if(x==index1){
                        sum1=nums1[i];
                    }
                    if(x==index2){
                        sum2=nums1[i];
                    }
                    i++;
                }
                else {
                    if(x==index1){
                        sum1=nums2[j];
                    }
                    if(x==index2){
                        sum2=nums2[j];
                    }
                    j++;
                }
                if(sum1!=0&&sum2!=0){
                    break;
                }
                x++;
            }
            return (sum1+sum2)/2.0;
        }else{//中位数为一个数的情况
            int index = l/2;
            int sum=0;
            int i=0;
            int j=0;
            int x=0;
            while(i<l1||j<l2){
                if(i>=l1){

                    if(x==index){
                        sum=nums2[j];
                        break;
                    }
                    j++;

                }else if(j>=l2){
                    if(x==index){
                        sum = nums1[i];
                        break;
                    }
                    i++;
                }
                else if(nums1[i]<nums2[j]){

                    if(x==index){
                        sum = nums1[i];
                        break;
                    }
                    i++;

                }
                else {

                    if(x==index){
                        sum=nums2[j];
                        break;
                    }
                    j++;

                }
                x++;
            }
            return sum;

        }
    }
    /**
     * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 "babad"
     **/
    public static String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        int length=s.length();
        //dp[i][j]表示第i到第j的子串是否为回文子串
        boolean[][]dp=new boolean[length][length];
        for(int i=0;i<length;i++){
            dp[i][i]=true;
        }
        int start=0;
        int max_len=1;
        //先遍历列，再遍历行，否则会出错
        for(int j=0;j<length;j++){
            for(int i=0;i<length;i++){
                if(i>=j){
                    continue;
                }
                if(i+1==j&&s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j);
                }
                if(dp[i][j]&&j-i+1>max_len){
                    max_len=j-i+1;
                    start=i;
                }

            }
        }
        String res=new String(s.toCharArray(),start,max_len);
        return res;
    }
    public static String longestPalindrome2(String s) {
        if(s == null || s.length() == 0) {
            return "" ;
        }
        int n = s.length() ;
        boolean[][] isPalindrome = new boolean[n][n] ;
        char[] ss = s.toCharArray() ;
        String ans = "" ;
        for(int i = 0 ; i < n ; i++){
            isPalindrome[i][i] = true ;//长度为1，一定是回文子串，记为true
            ans = s.substring(i,i+1) ;
        }
        for(int i = 0 ; i < n - 1 ; i++){
            if(ss[i] == ss[i+1]){//长度为2时，两个字符相同，为回文子串，记为true
                isPalindrome[i][i+1] = true ;
                ans = s.substring(i,i+2) ;
            }
        }
        for(int j = 3 ; j <= n ; j++) {//长度从3开始依次递增
            for (int i = 0; i + j - 1 < n; i++) {
                if (ss[i] == ss[i + j - 1] && isPalindrome[i + 1][i + j - 2]) {//始末位置字符相同且中间位置字符串为回文子串时，该字符串回文
                    isPalindrome[i][i + j - 1] = true;
                    if (j > ans.length()) {
                        ans = s.substring(i, i + j);
                    }
                }
            }
        }
        return ans ;

    }




    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
    }
}
