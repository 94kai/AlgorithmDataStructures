package com.xk.jikeshijian.algorithm;

import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author xuekai1
 * @date 2019/2/22
 */
public class LC1_TwoSum {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        Utils.printArray(solution1.twoSum(nums, target));
    }
}

class Solution1 {
    //用map存，注意存储的时候，key是数组的值，value是下标。每次存之前，先判断一下，target-它是否在map中已经有了
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int other = target - current;
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};
            }
            map.put(current, i);
        }
        return new int[2];
    }
}