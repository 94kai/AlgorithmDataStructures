package com.xk.book.datastructures.chapter1;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 泛型相关
 * Created by X.Sation on 2017/4/14.
 */

public class No1_4_1 {
    public static void main(String[] args) {
//        method1();
        method2();
        method3(new Person());
        method3(new WoMen());
        method3(new Man());
        method3(new Dog());
    }

    /**
     * 数组类型的兼容性
     */
    public static void method1() {
        Person[] m = new Man[10];
        m[0] = new WoMen();//WoMen IS-A Person,但是这里会报ArrayStoreException，却不会抛出ClassCastException
        //这里在编译的时候不会报错，说明java中对于数组是协变的，叫做协变数组类型，但是对于泛型是不协变的
        //List<Person>=List<Women> Women的泛型是不支持赋值给Person的
    }

    public static void method2() {
//        List<Person> m= new ArrayList<Man>();//编译不过
        List<? extends Person> m1 = new ArrayList<Man>();//编译通过
    }

    public static void method3() {
        Collection<String> c1=null;
        Collection<Integer> c2=null;
//        c2=c1;// 报错了 泛型是不支持协变的
        Object c3=c1;
        c2= (Collection<Integer>) c3;//不报错 但是运行会错 因为这里会有instanceof 检测
    }

    public static <T extends Comparable<? super Man>> void method3(T t) {
//        T t1=new T();类型擦除后，T可能是抽象类
    }

}

class Dog implements Comparable<Man> {
    @Override
    public int compareTo(Man dog) {
        return 0;
    }
}

class Man extends Person {

}

class WoMen extends Person {

}

class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person person) {
        return 0;
    }
}
