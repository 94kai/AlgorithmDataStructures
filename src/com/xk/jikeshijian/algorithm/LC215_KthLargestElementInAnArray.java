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
        int k = 2;
        int[] nums = {3,2,1,5,6,4};
        System.out.println("result:" + solution.findKthLargest(nums, k));
    }

}

class Solution {

    //利用k长度的小顶堆（java优先队列实现了小顶堆）来解这个题，容易了很多
    int findKthLargest(int[] nums, int k) {
        //默认是小顶堆，即堆顶元素最小
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        for (int num : nums) {

            if (queue.size() < k) {
                //如果长度还小于k，直接加入优先队列
                queue.add(num);
            } else {
                //长度大于k，先判断这个元素和堆顶的元素大小
                if (queue.peek() < num) {
                    //如果堆顶的比这个数小，那堆顶的太小了，把堆顶的移除，把这个数加入
                    queue.poll();
                    queue.add(num);
                } else {
                    //如果堆顶的都比这个数大，那这个数太小了，不需要加入
                }
            }
        }
        return queue.peek();
    }
}
