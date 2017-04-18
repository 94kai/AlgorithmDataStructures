package com.xk.chapter2;


import java.util.Random;

import static javax.swing.text.html.HTML.Attribute.N;

/**
 * 求解最大子序列问题
 * Created by X.Sation on 2017/4/17.
 */

public class No2_4_3 {
    private static int[] datas = new int[100000];

    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int j = random.nextInt(500);
            datas[i] = j - 250;
        }


        No2_4_3 self = new No2_4_3();

//        for (int i = 0; i < datas.length; i++) {
//            System.out.print(datas[i] + " ");
//        }
        System.out.println();
        long start = System.currentTimeMillis();
        System.out.println(self.method3(datas, 0, datas.length - 1));
        System.out.println("method3:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(self.method2(datas));
        System.out.println("method2:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(self.method1(datas));
        System.out.println("method1:" + (System.currentTimeMillis() - start));


    }


    /**
     * 三层嵌套 粗略的认为是O(N^3)
     *
     * @param datas
     * @return
     */
    private int method1(int[] datas) {
        int maxSum = 0;
        int currentMaxSum = 0;
        for (int i = 0; i < datas.length; i++) {
            for (int j = i; j < datas.length; j++) {
                currentMaxSum = 0;
                for (int k = i; k < j; k++) {
                    currentMaxSum += datas[k];
                }
                //循环完了，记录下来
                if (maxSum < currentMaxSum) {
                    maxSum = currentMaxSum;
                }
            }

        }

        return maxSum;
    }

    /**
     * 两层嵌套，减少了一个层级 O(N^2)
     *
     * @param datas
     * @return
     */
    private int method2(int[] datas) {

        int maxSum = 0;
        int currentMaxSum = 0;
        for (int i = 0; i < datas.length; i++) {
            currentMaxSum = 0;
            for (int j = i; j < datas.length; j++) {
                currentMaxSum += datas[j];
                //循环完了，记录下来
                if (maxSum < currentMaxSum) {
                    maxSum = currentMaxSum;
                }
            }

        }
        return maxSum;
    }


    /*
     * 分治法
     * 先找出前半部分的最大和,再找出后半部分的最大和
     * 再找出前半部分包含最后一个元素的最大和以及后半部分包括第一个元素的最大和，然后两者相加
     * 三者比较即可
     * @param datas
     * @param left 数据头
     * @param right 数据尾
     * @return
     */
    private int method3(int[] datas, int left, int right) {

        if (left == right) {
            return datas[left];
        }

        int middle = (left + right) / 2;
        //找出前面最大的0~(middle-1)
        int preMaxSum = method3(datas, left, middle);
        //找出后面最大的middle~length-1
        int afterMaxSum = method3(datas, middle + 1, right);
        //找出中间最大的
        int preAndCenterMaxSum = 0;
        int tempSum = 0;
        for (int i = middle; i >= left; i--) {
            tempSum += datas[i];
            if (tempSum > preAndCenterMaxSum) {
                preAndCenterMaxSum = tempSum;
            }
        }
        tempSum = 0;
        int afterAndCenterMaxSum = 0;
        for (int i = middle + 1; i <= right; i++) {
            tempSum += datas[i];
            if (tempSum > afterAndCenterMaxSum) {
                afterAndCenterMaxSum = tempSum;
            }
        }
        int middleMaxSum = preAndCenterMaxSum + afterAndCenterMaxSum;

        return Math.max(Math.max(preMaxSum, afterMaxSum), middleMaxSum);
    }
}
