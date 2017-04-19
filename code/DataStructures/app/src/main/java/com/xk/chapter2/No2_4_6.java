package com.xk.chapter2;

import com.sun.nio.sctp.Association;
import com.sun.xml.internal.bind.v2.runtime.AssociationMap;

import java.math.BigInteger;

import sun.rmi.runtime.Log;

/**
 * Created by xuekai on 2017/4/19.
 */

public class No2_4_6 {
    //底数
    private int x=2;
    //幂
    private int n=110;

    public static void main(String[] args) {
        No2_4_6 self = new No2_4_6();

        System.out.println();
        long start = System.currentTimeMillis();
        System.out.println(self.method(self.x,self.n));
        System.out.println("method1耗时:" + (System.currentTimeMillis() - start) + "ms");

    }

    /**
     * 求x的n次幂
     * @param x
     * @param n
     * @return
     */
    private BigInteger method(int x,int n){
        if (n==0) {
            return BigInteger.valueOf(1);
        }
        if (n==1) {
            return BigInteger.valueOf(x);
        }
        if (n%2==0) {
            //偶数次幂
            BigInteger temp = method(x, n / 2);
            return temp.multiply(temp);
//            return method(x*x,n/2);
        }else{
            //奇数次幂,下面两种写法，效率是一样的，看乘法的次数就知道了，可以通过打印乘法的次数来判断
            BigInteger temp = method(x, n / 2);
            return temp.multiply(temp).multiply(BigInteger.valueOf(x));

//            BigInteger temp = method(x, n-1);
//            return temp.multiply(BigInteger.valueOf(x));
        }
    }
}
