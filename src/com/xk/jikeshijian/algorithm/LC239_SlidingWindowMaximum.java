package com.xk.jikeshijian.algorithm;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 *
 * @author xuekai1
 * @date 2019/2/13
 */
public class LC239_SlidingWindowMaximum {


    public static void main(String[] args) {
        Solution239_2 solution = new Solution239_2();
        //该用例可以证明，双端队列法需要while循环
//        int k = 3;
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 4;
        int[] nums = {1, 3, 1, 2, 0, 5};
//        System.out.println(solution.maxSlidingWindow(nums,k));
        for (int i : solution.maxSlidingWindow(nums, k)) {
            System.out.println(i);
        }
    }

}

//用优先队列的方式解。每次增加、移除元素都需要调整，一次调整的时间复杂度为logn？？？ 感觉应该会比这个大
class Solution239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        //窗口的左后一个左节点的下标
        int lastLeft = nums.length - k;

        int res[] = new int[lastLeft + 1];
        //先把初始的k个添加进来
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[0] = queue.peek();

        //right = left + 2;
        //开始移动，每次移动都输出当前的堆顶
        for (int left = 1; left <= lastLeft; left++) {
            int right = left + k - 1;
            queue.remove(nums[left - 1]);
            queue.add(nums[right]);
            res[left] = queue.peek();
        }
        return res;
    }
}


//用双队列的方式解。注意 window里存的是下标
//实际上在新元素i进队列的时候会将前面下标对应的值小于i对应的值的元素均剔除，且是从队尾开始，剔除之后再让新元素i入队。
// 所以双端队列主要是用到了两点：
//              一是在队头取当前窗口最大值，
//              二是新进元素从队尾开始剔除小于自己的元素。
// 对于大小为N的列表，窗口大小为K，在后面N-K次循环中，每次都会新进一个元素，剔除一个或多个元素，所以总体来看会是O(n)的时间复杂度
class Solution239_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        //创建一个双端队列，用来作为window，用来存储window所在的区域的元素的下标
        Deque<Integer> window = new ArrayDeque<>();
        //创建一个数组，长度为nums.length - k + 1，存储每次移动之后的最大值
        int res[] = new int[nums.length - k + 1];

        //从头到尾遍历数组
        for (int i = 0; i < nums.length; i++) {
            //假如window长度为3，那么遍历第3个之后的时候，相当于窗口开始移动了，需要把窗口左端之前的移除掉，当然移除的时候需要做一个判断，窗体内的第一个元素的下标是否超出窗口左端了。
            if (i >= k && window.getFirst() <= i - k) {
                window.removeFirst();
            }
            //窗口左边以外的元素移除之后，接下来是重点，需要从右开始移除小于将要加入的元素
            while (window.size() > 0 && nums[window.getLast()] < nums[i]) {
                window.removeLast();
            }
            //将新元素加入
            window.add(i);
            //遍历到第3个以及之后的元素时，就可以每次把最大值加入到结果集了，最大值就是窗体的第一个元素
            if (i >= k - 1) {
                res[i - k + 1] = nums[window.getFirst()];
            }
        }
        return res;
    }
}
