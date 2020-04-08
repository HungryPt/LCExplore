package com.rulinzi.arr;

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
                if(nums[i]+nums[j]==target){
                    arrs[0]=i;
                    arrs[1]=j;
                    return arrs;
                }
            }
        }
        return  null;
    }
}
