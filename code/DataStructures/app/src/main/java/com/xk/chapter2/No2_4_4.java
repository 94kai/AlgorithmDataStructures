package com.xk.chapter2;

import java.util.Random;

/**
 * 折半查找 O(logN)
 * Created by xuekai on 2017/4/18.
 */

public class No2_4_4 {
    private static int[] datas = new int[10001001];
    private int x = 100;
    private int index=10000901;
    public static void main(String[] args) {

        Random random = new Random();
        datas[0]=0;
        for (int i = 1; i < datas.length; i++) {
            int j = random.nextInt(10);
            datas[i] =datas[i-1]+j;
        }
        No2_4_4 self = new No2_4_4();
        self.x=datas[self.index];

        System.out.println();
        long start = System.currentTimeMillis();
        System.out.println(self.method1(datas, 0, datas.length - 1));
        System.out.println("method1耗时:" + (System.currentTimeMillis() - start) + "ms");

    }


    private int method1(int[] datas, int left, int right) {
        int middle = (left + right) / 2;
        if (datas[(left + right) / 2] == x) {
            return (left + right) / 2;
        }
        if (left == right) {
            return -1;
        }
        if ((x < datas[middle])) {
            return method1(datas, left,middle);
        }else{
            return method1(datas, middle+1,right);
        }
    }





}
