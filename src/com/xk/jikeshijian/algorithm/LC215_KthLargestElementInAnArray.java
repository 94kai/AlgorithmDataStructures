package com.xk.jikeshijian.algorithm;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @author xuekai1
 * @date 2019/2/13
 */
public class LC215_KthLargestElementInAnArray {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 7;
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println("result:" + solution.findKthLargest(nums, k));
    }

}

class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(k);

        return 0;
    }
}
