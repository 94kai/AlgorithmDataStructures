package com.xk.book.datastructures.chapter1;



/**
 * 现有一个方法，printDigit,只能打印一个正一位数，请写一个方法print，用来打印任意一个正整数
 * Created by X.Sation on 2017/4/14.
 */

public class No1_3_1 {
    public static void main(String[] args) {
        print(1234567890);
    }


    private static void print(int num) {
        if (isDigit(num)) {//基准情形
            printDigit(num);
        }else{
            //1.打印前面的几位
            print(num/10);
            //2.打印最后位
            print(num%10);
        }
    }


    /**
     * 打印一位数
     *
     * @param digit
     */
    private static void printDigit(int digit) {
        if (isDigit(digit)) {
            System.out.print(digit);
            return;
        }
        throw new IllegalStateException("不能输出两位数");
    }

    private static boolean isDigit(int num) {
        if (num >= 0 && num < 10) return true;
        return false;
    }
}
