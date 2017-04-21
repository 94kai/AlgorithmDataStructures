package com.xk.chapter3;

import java.util.Scanner;

/**
 * Created by xuekai on 2017/4/21.
 */

public class No3_6_3 {
    public static void main(String[] args){
        Stack stack = new Stack();
        No3_6_3 self = new No3_6_3();

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("+")||next.equals("-")||next.equals("*")) {
                Object a = stack.pop();
                Object b = stack.pop();

            }



        }


    }



}


class Stack{
    int length=0;
    Object s[]=new Object[100];
    public void push(Object o){
        s[length]=o;
        length++;
    }


    public Object pop(){
        length--;
        return s[length];
    }
}
