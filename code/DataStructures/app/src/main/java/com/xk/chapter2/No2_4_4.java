package com.xk.chapter2;

import java.util.Random;

/**
 * 折半查找
 * Created by xuekai on 2017/4/18.
 */

public class No2_4_4 {
    private static int[] datas = new int[10001];
    //数组中数字范围 -number~number
    private static int number = 250;
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < datas.length; i++) {
            int j = random.nextInt(number * 2);
            datas[i] = j - number;
        }


        No2_4_3 self = new No2_4_3();
        System.out.println();

        long start = System.currentTimeMillis();

        System.out.println("method1耗时:" + (System.currentTimeMillis() - start)+"ms");
    }

}
