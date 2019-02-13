package com.xk.book.datastructures.chapter2;

import java.util.Random;

/**
 * 欧几里德算法，求两个数的最大公因数
 * Created by xuekai on 2017/4/18.
 */

public class No2_4_5 {
    public static void main(String[] args) {

        No2_4_5 self = new No2_4_5();

        System.out.println();
        long start = System.currentTimeMillis();
        System.out.println(self.method(33, 90));
        System.out.println("method1耗时:" + (System.currentTimeMillis() - start) + "ms");

    }


    /**
     * 令m>=n,如果n>m,则第一次循环会把m和n交换
     *
     * @param m
     * @param n
     * @return
     */
    private int method(int m, int n) {
        //把n赋给m，余数赋给n,一直循环，直到余数为0
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }


}
