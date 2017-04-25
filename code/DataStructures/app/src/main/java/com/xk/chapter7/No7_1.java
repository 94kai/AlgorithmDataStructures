package com.xk.chapter7;

import java.util.Random;

/**
 * Created by xuekai on 2017/4/25.
 */

public class No7_1 {
    public static void main(String args[]) {
        No7_1 self = new No7_1();

        int count = 900000;
        Random random = new Random();
        int[] data = new int[count];
        for (int i = 0; i < count; i++) {
//            data[i] = random.nextInt(count);
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


//        堆排序
//        long start = System.currentTimeMillis();
//
//        self.dui(data);
//        System.out.println(System.currentTimeMillis() - start);


//        int[] data = {9, 12, 17, 30, 50, 20, 60, 65, 4, 19};

        long start1 = System.currentTimeMillis();
        self.dui(data);
        System.out.println(System.currentTimeMillis() - start1);

        for (int i = 0; i < data.length - 1; i++) {
            int i1 = data[i + 1] - data[i];
            if (i1 < 0) {
                System.out.println("hhh" + i);
            }
        }
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
        for (int i = n / 2; i >= 0; i--) {
            turnMaxHeap(data, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            swop(data, 0, i);
            turnMaxHeap(data, 0, i);
        }
    }

    /**
     * 把data[n]和他的左右子树转换成最大堆，如果没有孩子，就不用管了  递归写法
     * *****注意，递归写法一定要小心坑：不要重复计算，比如我之前在这个方法里没有加入if (temp==left)的判断，导致运算时间在该方法内乘2了，总效率就不是除2这么简单了
     */
    private void turnMaxHeap(int[] data, int n, int length) {
        int left = n * 2 + 1;
        int right = n * 2 + 2;
        if (length <= left) {//没有孩子
            return;
        }

        int temp;

        if (length <= right) {//只有左孩子
            temp = left;
        } else {
            temp = ((data[left] > data[right]) ? left : right);
        }

        if (data[n] < data[temp]) {
            swop(data, n, temp);
        }
        if (temp == left) {//这一步很关键，如果交换的是左孩子，那么右孩子就没必要动了
            turnMaxHeap(data, left, length);
        } else {
            if (length <= right) {//只有左孩子
            } else {
                turnMaxHeap(data, right, length);
            }

        }


    }


    /**
     * 把data[n]和他的左右子树转换成最大堆，如果没有孩子，就不用管了  非递归写法
     */
    private void turnMaxHeap1(int[] data, int n, int length) {
        int left = n * 2 + 1;
        int right = n * 2 + 2;

        int largest = n;
        int temp;

        while (left < length || right < length) {
            if (left < length && data[largest] < data[left]) {
                largest = left;
            }

            if (right < length && data[largest] < data[right]) {
                largest = right;
            }

            if (n != largest)   //如果最大值不是父节点
            {
                temp = data[largest]; //交换父节点和和拥有最大值的子节点交换
                data[largest] = data[n];
                data[n] = temp;

                n = largest;         //新的父节点，以备迭代调堆
                left = n * 2 + 1;
                right = n * 2 + 2;
            } else {
                break;
            }
        }
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

