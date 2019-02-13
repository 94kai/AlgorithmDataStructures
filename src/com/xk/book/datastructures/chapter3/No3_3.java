package com.xk.book.datastructures.chapter3;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 集合相关知识
 * Created by xuekai on 2017/4/20.
 */

public class No3_3 {
    public static void main(String[] args) {
        No3_3 self = new No3_3();

        LinkedList<Object> list = new LinkedList<>();
        for (int i = 0; i < 400000; i++) {
            list.add(i);
        }
        long start=System.currentTimeMillis();
        self.removeEven(list);
        System.out.println("耗时："+(System.currentTimeMillis()-start));

//        for (Object o : list) {
//            System.out.println(o);
//        }
//        LinkedList linkedList = new LinkedList();
//        List arrayList=new ArrayList();
//        self.addToLast(arrayList,100000);
//        self.addToLast(linkedList,100000);
//        arrayList.clear();
//        linkedList.clear();
//
//        self.addToFirst(arrayList,100000);
//        self.addToFirst(linkedList,100000);

    }


    /**
     * 高效的删除偶数数据
     * @param list
     */
    private void removeEven(List list){
        int i=0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((int)iterator.next())%2==0) {
                iterator.remove();
            }
        }
    }


    /**
     * arraylist添加到头部是很耗时的
     * linkedlist不会
     * @param list
     * @param n
     */
    private void addToFirst(List<Integer> list,int n){
        long start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(0,i);
        }
        System.out.println("添加到头部，"+list.getClass().getSimpleName()+"耗时："+(System.currentTimeMillis()-start));
    }

    /**
     * arraylist添加到尾部不耗时的
     * linkedlist也不会
     * @param list
     * @param n
     */
    private void addToLast(List<Integer> list,int n){
        long start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        System.out.println("添加到尾部，"+list.getClass().getSimpleName()+"耗时："+(System.currentTimeMillis()-start));
    }


    //Collection继承了Iterable接口，使得它可以使用增强for循环，换句话说，实现了Iterable的类可以使用增强for循环
    Collection collection = new Collection() {

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            //实现Iterable接口，就要实现这个方法，他要返回一个Iterator对象，该对象要实现三个方法，这样就可以实现
            //Iterator的功能了。
            //1.boolean hasNext();  2.E next();  3.void remove();


            //Iterator中的remove方法，可以remove刚才next时返回的这一项，remove之后，如果没有调用next是不能再
            //继续remove的，而Collection中的remove需要知道remove的是哪一项，所以效率会低一点。另一方面，如果
            //正在迭代某一个集合，那么对这个集合进行结构的改变(增加，删除等)，会抛出ConcurrentModificationException
            //异常，但是用Iterator的remove方法，不会，所以推荐使用这个remove
            return null;
        }


        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑以上表示了一个Collection（集合必备的功能），下面也是必备的，不过含义类似


        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }


        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }
    };


    //ArrayList get/set方便，add/remove耗时，用的是可变数组
    //LinkedList 相反，用的是双链表
    List list = new List() {
        @Override
        public Object get(int index) {
            return null;
        }

        @Override
        public Object set(int index, Object element) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator listIterator() {
            return null;
        }

        @Override
        public ListIterator listIterator(int index) {
            return null;
        }

        @Override
        public List subList(int fromIndex, int toIndex) {
            return null;
        }

// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑以上表示了一个List（相比于Collection新增的功能），下面也是必备的，不过含义类似


        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection c) {
            return false;
        }

        @Override
        public void clear() {

        }


        @Override
        public void add(int index, Object element) {

        }

        @Override
        public Object remove(int index) {
            return null;
        }


        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }
    };


    /**
     * 继承自Iterator，比它添加了previous的功能
     */
    ListIterator listIterator=new ListIterator() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    };

}
