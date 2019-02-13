package com.xk.book.datastructures.chapter7;

import java.util.Random;

/**
 * Created by xuekai on 2017/4/25.
 */

public class No7_2 {
    public static void main(String args[]) {

        Integer[][] a5;
        a5 = new Integer[3][];
        for(int i = 0; i < a5.length; i++) {
            a5[i] = new Integer[3];
            for(int j = 0; j < a5[i].length; j++)
                a5[i][j] = new Integer(i*j);
        }
        for (int i = 0; i < a5.length; i++) {
            for (int i1 = 0; i1 < a5[i].length; i1++) {
                System.out.print(a5[i][i1]);
            }
            System.out.println();
        }
    }
}
class User{

}
