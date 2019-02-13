package com.xk.book.datastructures.chapter3.no_3_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xuekai on 2017/4/20.
 */

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> objects = new MyLinkedList<Integer>();
        objects.add(2);
        objects.add(12);
        objects.add(232);
        objects.add(2213);
        objects.add(232);
        objects.add(212);
        objects.add(42);
        objects.add(24);


////        System.out.println(objects.head);
//        for (int i = 0; i < objects.size(); i++) {
//            Integer integer = objects.get(i);
//            objects.remove(i);
//            System.out.println(integer+"   "+i);
//        }

        for (Integer object : objects) {
            objects.remove(object);        }

//        objects.getNode(4);
//        Iterator<Integer> iterator = objects.iterator();
//        while (iterator.hasNext()){
//            Integer next = iterator.next();
//            System.out.println(next);
//        }
//        for (Integer object : objects) {
//            System.out.println(object);
//        }
//        for (int i = 0; i < objects.size(); i++) {
//            objects.remove(objects.get(i));
//        }
    }
}
