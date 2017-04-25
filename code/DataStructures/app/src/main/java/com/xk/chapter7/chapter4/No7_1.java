package com.xk.chapter7.chapter4;

import java.util.Random;

/**
 * Created by xuekai on 2017/4/25.
 */

public class No7_1 {
    public static void main(String args[]) {
        No7_1 self = new No7_1();

        int count = 9000;
        Random random = new Random();
        int[] data = new int[count];
        for (int i = 0; i < count; i++) {
//            data[i]=random.nextInt(count);
            data[i] = count - i;
        }
//        long start = System.currentTimeMillis();
//        self.xier(data);
//        System.out.println(System.currentTimeMillis() - start);
////        for (int i = 0; i < data.length; i++) {
////            System.out.print(data[i]+" ");
////        }
//
//
//        for (int i = 0; i < data.length - 1; i++) {
//            int i1 = data[i + 1] - data[i];
//            if (i1 < 0) {
//                System.out.println("hhh" + i);
//            }
//        }

        long start=System.currentTimeMillis();

//        int[] data = {9, 12, 17, 30, 50, 20, 60, 65, 4, 19};
        self.dui(data);
        System.out.println(System.currentTimeMillis()-start);
    }


    /**
     * 插入排序O(N^2)
     *
     * @param data
     */
    private void charupaixu(int[] data) {
        int n = data.length;
        int j;
        int temp;

        //n-1趟排序，第i趟排序表示处理下标为i以及之前的,首先把下标为i的存到temp中，然后依次和前面的比较，然后把temp插入到合适的位置
        for (int i = 1; i <= n - 1; i++) {
            temp = data[i];
            for (j = i; j > 0 && temp < data[j - 1]; j--) {
                data[j] = data[j - 1];
            }
            data[j] = temp;
        }
    }


    /**
     * 希尔排序O(N^2)
     *
     * @param data
     */
    private void xier(int[] data) {
        int n = data.length;
        int gap;

        for (gap = n / 2; gap > 0; gap /= 2) {
            int j;
            int temp;

            //n-1趟排序，第i趟排序表示处理下标为i以及之前的,首先把下标为i的存到temp中，然后依次和前面的比较，然后把temp插入到合适的位置
            for (int i = gap; i <= n - 1; i++) {
                temp = data[i];
                for (j = i; j >= gap && temp < data[j - gap]; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }

    }


    /**
     * 堆排序O(N^2)
     * 1.数组=>二叉树，直接放进去就是了，不用做任何处理
     * 2.从数组最后一个元素开始处理，以它为头，转换成一个最小堆（这个堆只考虑最多三个元素）
     * 3.以上就完成了最小堆（整体）的建立
     * 4.第0个元素和第（n-1）交换，然后从0~（n-1）的树重新转成最小堆，用2，3的方法
     * 5.第0个和第（n-2）交换，然后从0~（n-2）的树重新转成最小堆，用2，3的方法
     * 6....
     *
     * @param data
     */
    private void dui(int[] data) {
        int n = data.length;
        for (int i = n - 1; i >= 0; i--) {
            turnMinHeap(data, i,n);
        }
        for (int k=1;k<n;k++) {
            swop(data, 0, n - k);
            for (int i = n - k-1; i >= 0; i--) {
                turnMinHeap(data, i,n-k);
            }
        }
    }

    /**
     * 把data[n]和他的左右子树（总共3个元素）转换成最小堆，如果没有孩子，就不用管了
     */
    private void turnMinHeap(int[] data, int n,int length) {
        int left = n * 2 + 1;
        int right = n * 2 + 2;
        if (length <= left) {//没有孩子
            return;
        }

        if (length <= right) {//只有左孩子
            if (data[n] <= data[left]) {
                return;
            }
            swop(data, n, left);
            return;
        }
        if (data[n] <= ((data[left] < data[right]) ? data[left] : data[right])) {
            return;
        }
        swop(data, n, ((data[left] < data[right]) ? left : right));
    }


    /**
     * 交换数组中的两个元素
     *
     * @param data
     * @param a
     * @param b
     */
    private void swop(int[] data, int a, int b) {
        int temp;
        temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }


}
