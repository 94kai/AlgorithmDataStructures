package com.xk.chapter3.no_3_4;

import java.util.Iterator;

/**
 * Created by xuekai on 2017/4/20.
 */

public class Main {
    public static void main(String[] args) {
        MyArrayList<Object> objects = new MyArrayList<>();
        System.out.println("x");
        objects.add(2);
        objects.add(12);
        objects.add(232);
        objects.add(2213);
        objects.add(232);
        objects.add(212);
        objects.add(42);
        objects.add(24);

        Iterator iterator = objects.iterator();
        while (iterator.hasNext()){
            if (((int)iterator.next())%2==0) {
                iterator.remove();
            }
        }

        for (Object object : objects) {
            System.out.println(object);
        }
    }
}
