package com.xk.chapter2;


/**
 * 求解最大子序列问题
 * Created by X.Sation on 2017/4/17.
 */

public class No2_4_3 {
    private static int[] datas = {4, -3, 5, -2, -1, 2, 6, -2};

    public static void main(String[] args) {

        No2_4_3 self = new No2_4_3();

        System.out.println(self.method2(datas));
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

}
