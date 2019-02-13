package com.xk.book.datastructures.chapter3.no_3_5;

import com.xk.chapter3.no_3_4.MyArrayList;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * LinkedList的实现(不考虑数组越界，考虑并发处理)
 * Created by xuekai on 2017/4/20.
 */

public class MyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    public Node head = new Node(null, null, null);
    private Node tail = new Node(null, null, null);
    private int modCount = 0;


    public MyLinkedList() {
        clear();
    }

    public void clear() {
        head.nextNode = tail;
        tail.lastNode = head;
        //还有对每一个node进行清除，解决内存泄漏问题。为了方便，这里不处理了
        size = 0;
        modCount++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        addBefore(tail, item);
    }

    public void add(T item, int index) {
        addBefore(getNode(index), item);
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public void set(T value, int index) {
        getNode(index).value = value;
    }


    public T remove(int index) {
        Node<T> node = getNode(index);
        remove(node);
        return node.value;
    }

    public void addBefore(Node<T> node, T value) {
        size++;
        modCount++;
        node.lastNode = node.lastNode.nextNode = new Node<>(node.lastNode, node, value);
    }

    public T remove(Node<T> node) {
        node.nextNode.lastNode = node.lastNode;
        node.lastNode.nextNode = node.nextNode;
        size--;
        modCount++;
        return node.value;
    }

    public Node<T> getNode(int index) {
        Node<T> node;

        int middle = size() / 2;
        if (index > middle) {
            node = tail.lastNode;
            for (int i = size; i > index; i--) {
                node = node.lastNode;
            }
        } else {
            node = head.nextNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
        }

        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }


    private class MyIterator<T> implements Iterator<T> {

        /**
         * 只有调用了next，才可以调用remove，调用一次next，只能remove一次
         */
        private boolean okToRemove = false;
        private Node<T> node = head.nextNode;

        /**
         * 预期的modCount
         */
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return node != tail;
        }

        @Override
        public T next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("预期的不对");
            }
            T value = node.value;
            node = node.nextNode;
            okToRemove = true;
            return value;
        }

        @Override
        public void remove() {
            if (expectedModCount != modCount) {
                throw new IllegalStateException("预期的不对");
            }
            if (!okToRemove) {
                //不可以remove
                throw new IllegalStateException("没有调用next，不能remove");
            }

            MyLinkedList.this.remove(node.lastNode);
            expectedModCount++;
            okToRemove = false;

        }
    }

    private class Node<T> {
        public Node lastNode;
        public Node nextNode;
        public T value;

        public Node(Node lastNode, Node nextNode, T value) {
            this.lastNode = lastNode;
            this.nextNode = nextNode;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "lastNode=" + lastNode +
                    ", nextNode=" + nextNode +
                    ", value=" + value +
                    '}';
        }
    }
}
